package com.cn.template.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

@Slf4j
public class Base64Util {

    private Base64Util() {

    }

    /**
     * 生成base64码
     *
     * @param b
     * @return
     */
    public static String encode(byte[] b) {
        return Base64.encodeBase64String(b);
    }

    /**
     * 将Base64数据解码为octects
     *
     * @param base64Str Base64数据
     * @return 解码数据
     */
    public static byte[] decode(String base64Str) {
        return Base64.decodeBase64(base64Str);
    }
}
