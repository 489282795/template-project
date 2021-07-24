package com.cn.template.common.exception;

import com.cn.template.common.enums.ErrorContstant;

public class UnknownException extends RuntimeException {

    private boolean success;

    private Object result;

    private String code;

    private String message;

    public UnknownException(ErrorContstant.ErrorEnum errorEnum){
        this.code = errorEnum.getErrorCode();
        this.message = errorEnum.getErrorMsg();
        this.success = false;
        this.result = null;
    }

    public String getCode(){
        return code;
    }

    public void setCode(String code){
        this.code = code;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }
}
