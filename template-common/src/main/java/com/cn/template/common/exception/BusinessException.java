package com.cn.template.common.exception;

import com.cn.template.common.enums.BusinessContstant;

public class BusinessException extends RuntimeException {

    private boolean success;

    private Object result;

    private String code;

    private String message;

    public BusinessException(BusinessContstant.BusinessEnum businessEnum) {
        this.code = businessEnum.getCode();
        this.message = businessEnum.getMessage();
        this.success = false;
        this.result = null;
    }

    public BusinessException(boolean success, BusinessContstant.BusinessEnum businessEnum) {
        this.code = businessEnum.getCode();
        this.message = businessEnum.getMessage();
        this.success = success;
        this.result = null;
    }

    public BusinessException(boolean success, String code, String message, Object result) {
        this.code = code;
        this.message = message;
        this.success = success;
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessge() {
        return message;
    }

    public void setMessage(String messge) {
        this.message = messge;
    }

}
