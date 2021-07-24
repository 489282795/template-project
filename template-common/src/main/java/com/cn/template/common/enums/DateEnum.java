package com.cn.template.common.enums;

public enum DateEnum {
    DATE_01("HHmmss"),
    DATE_02("yyyy/MM/ddHH:mm:ss"),
    DATE_03("yyyyMMdd"),
    DATE_04("yyMMdd"),
    DATE_05("yyyyMMddHHmmss"),
    DATE_06("yyyyMMddHHmmssSSS"),
    DATE_07("yyMMddHHmmss"),
    DATE_08("yyyy.MM.dd HH:mm:ss"),
    DATE_09("yyyy-MM-dd HH:mm:ss"),
    DATE_10("HHmm"),
    DATE_11("HH:mm:ss"),
    DATE_12("yyyyMMdd HH:mm:ss"),
    DATE_13("yyyyMMddHHmm"),
    DATE_14("yyyy-MM-dd HH:mm"),
    DATE_15("yyyy-MM-dd"),
    DATE_16("yyyyMMdd"),
    DATE_17("yyyy-MM-dd"),
    DATE_18("yyyyMMddHHmmss");

    private String date;

    DateEnum(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
}
