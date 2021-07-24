package com.cn.template.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.IOException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class HttpRequestUtil {

    /**
     * 超时时间
     */

    private int timeOut = 10000;

    /**
     * 请求配置
     */
    private RequestConfig requestConfig;

    /**
     * 关闭请求
     */
    private CloseableHttpClient httpClient;

    /**
     * 构造函数，用以传递参数isHttps
     *
     * @param isHttps
     */
    public HttpRequestUtil(Boolean isHttps) {
        httpClient = this.getHttpClient(isHttps);
        this.initRequestConfig();
    }

    /**
     * 关闭Http请求
     *
     * @param isHttps
     * @return
     */
    private CloseableHttpClient getHttpClient(Boolean isHttps) {
        CloseableHttpClient clbHttpClient = null;
        try {
            if (isHttps) {
                TrustManager[] trustManagers = new TrustManager[1];
                trustManagers[0] = new X509TrustManager() {
                    @Override
                    public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }
                    @Override
                    public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                    }
                    @Override
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                };
                SSLContext sslContext = SSLContext.getInstance("TLS");
                sslContext.init(new KeyManager[0], trustManagers, new SecureRandom());
                SSLContext.setDefault(sslContext);
                sslContext.init(null, trustManagers, null);
                SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
                clbHttpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
            } else {
                clbHttpClient = HttpClients.custom().build();
            }
        } catch (Exception e) {
            log.error("Http请求关闭出现异常：{}", e);
        }
        return clbHttpClient;
    }

    /**
     * 初始化请求配置
     */
    private void initRequestConfig() {
        requestConfig = RequestConfig.custom().setSocketTimeout(timeOut).setConnectTimeout(timeOut).build();
    }

    /**
     * 返回Http请求结果，并进一步传参
     *
     * @param url
     * @param param
     * @return
     */
    public String executePostJsonForWeb(String url, JSONObject param) {
        return this.executePostValuePairForWeb(url, null, "UTF-8", param);
    }

    /**
     * 进行Http请求，并返回请求结果
     *
     * @param url         请求地址
     * @param contentType 请求类型
     * @param encoding    字符编码
     * @param param       请求参数
     * @return
     */
    public String executePostValuePairForWeb(String url, String contentType, String encoding, JSONObject param) {
        HttpPost httpPost = new HttpPost(url);
        try {
            httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            httpPost.setConfig(requestConfig);
            this.initMethodParam(httpPost, contentType, encoding);
            if (param != null) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                for (String key : param.keySet()) {
                    nvps.add(new BasicNameValuePair(key, param.getString(key)));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(nvps));
            }
            return this.execute(httpPost, this.getHttpClient());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            httpPost.releaseConnection();
        }
    }

    /**
     * 设置请求参数
     *
     * @param method
     * @param contentType
     * @param encoding
     */
    private void initMethodParam(HttpUriRequest method, String contentType, String encoding) {
        if (contentType != null) {
            method.setHeader(HttpHeaders.CONTENT_TYPE, contentType);
        }
        method.setHeader(HttpHeaders.CONTENT_ENCODING, encoding);
        method.setHeader(HttpHeaders.TIMEOUT, "60000");
    }

    /**
     * 执行Http请求，并返回请求结果
     *
     * @param method
     * @param httpClient
     * @return
     * @throws RuntimeException
     * @throws IOException
     */
    private String execute(HttpUriRequest method, CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(method);
            HttpEntity entity = response.getEntity();
            return EntityUtils.toString(entity, method.getFirstHeader(HttpHeaders.CONTENT_ENCODING).getValue());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    /**
     * 返回关闭Http请求参数
     *
     * @return
     */
    public CloseableHttpClient getHttpClient() {
        return httpClient;
    }

}
