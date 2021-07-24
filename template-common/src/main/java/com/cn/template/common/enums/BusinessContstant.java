package com.cn.template.common.enums;

public class BusinessContstant {

    private BusinessContstant(){

    }

    public enum BusinessEnum{
        ACCIDENT_BUSINESS_DATA_EMPTY("",""),
        ;

        private String code;
        private String message;

        BusinessEnum(String code,String message){
            this.code = code;
            this.message = message;
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
}
