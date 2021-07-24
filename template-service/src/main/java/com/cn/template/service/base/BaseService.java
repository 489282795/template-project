package com.cn.template.service.base;


import com.cn.template.common.bean.base.Response;
import com.cn.template.common.enums.ErrorEnum;
import com.cn.template.common.enums.SuccessEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BaseService {

    /**
     * 成功返回Response
     *
     * @param errorMsg  错误信息
     * @param errorCode 错误码
     * @param object    结果集
     * @return
     */
    public Response response(String errorMsg, String errorCode, Object object) {
        Response response = new Response();
        response.setMessage(errorMsg);
        response.setStatusCode(errorCode);
        response.setResult(object);
        return response;
    }

    /**
     * 成功返回Response
     *
     * @param errorMsg  错误信息
     * @param errorCode 错误码
     * @return
     */
    public Response response(String errorMsg, String errorCode) {
        Response response = new Response();
        response.setMessage(errorMsg);
        response.setStatusCode(errorCode);
        return response;
    }

    /**
     * 成功返回Response
     *
     * @param enums
     * @param object
     * @return
     */
    public Response response(SuccessEnum enums, Object object) {
        Response response = new Response();
        response.setMessage(enums.getErrorDesc());
        response.setStatusCode(enums.getErrorCode());
        response.setResult(object);
        return response;
    }

    /**
     * 成功返回Response
     *
     * @param object 结果集
     * @return
     */
    public Response response(Object object) {
        Response response = new Response();
        response.setMessage(SuccessEnum.SUCCESS_00.getErrorDesc());
        response.setStatusCode(SuccessEnum.SUCCESS_00.getErrorCode());
        response.setResult(object);
        return response;
    }


    /**
     * 成功返回Response
     *
     * @param enums
     * @return
     */
    public Response response(SuccessEnum enums) {
        Response response = new Response();
        response.setMessage(enums.getErrorDesc());
        response.setStatusCode(enums.getErrorCode());
        return response;
    }

    /**
     * 错误返回Response
     *
     * @param enums
     * @param object
     * @return
     */
    public Response response(ErrorEnum enums, Object object) {
        Response response = new Response();
        response.setMessage(enums.getErrorDesc());
        response.setStatusCode(enums.getErrorCode());
        response.setResult(object);
        return response;
    }

    /**
     * 错误返回Response
     *
     * @param enums
     * @return
     */
    public Response response(ErrorEnum enums) {
        Response response = new Response();
        response.setMessage(enums.getErrorDesc());
        response.setStatusCode(enums.getErrorCode());
        return response;
    }

}
