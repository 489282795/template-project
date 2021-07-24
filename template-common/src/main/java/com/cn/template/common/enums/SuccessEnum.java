package com.cn.template.common.enums;

public enum SuccessEnum {

    SUCCESS_00("00", "成功");

    private String errorCode;
    private String errorDesc;

    SuccessEnum(String errorCode, String errorDesc) {
        this.errorCode = errorCode;
        this.errorDesc = errorDesc;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDesc() {
        return errorDesc;
    }
}
