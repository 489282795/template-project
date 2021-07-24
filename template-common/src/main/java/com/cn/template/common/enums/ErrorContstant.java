package com.cn.template.common.enums;

public class ErrorContstant {

    private ErrorContstant(){

    }

    public enum ErrorEnum{

        UN_KNOW_ERROR("0001","服务繁忙，请稍后再试！"),
        PARAM_CHECK_ERROR("0002","参数校验异常！"),
        ;

        private String errorCode;
        private String errorMsg;

        ErrorEnum(String errorCode,String errorMsg){
            this.errorCode = errorCode;
            this.errorMsg = errorMsg;
        }

        public String getErrorCode(){
            return errorCode;
        }

        public String getErrorMsg(){
            return errorMsg;
        }


    }
}
