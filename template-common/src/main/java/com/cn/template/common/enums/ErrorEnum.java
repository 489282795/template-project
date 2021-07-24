package com.cn.template.common.enums;

public enum ErrorEnum {

    ERROR_0001("0001", "0001"),
    ERROR_0002("0002", "0002"),
    ERROR_0003("0003", "0003!"),
    ERROR_0004("0004", "0004!"),
    ERROR_0005("0005", "0005!"),
    ERROR_0006("0006", "失败!"),
    ERROR_0007("0007", "失败!");

    private String errorCode;
    private String errorDesc;

    ErrorEnum(String errorCode, String errorDesc) {
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
