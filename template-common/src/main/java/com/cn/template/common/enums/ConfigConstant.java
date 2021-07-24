package com.cn.template.common.enums;

public class ConfigConstant {

    private ConfigConstant() {

    }

    public enum ConfigEnum {
        APP_ENV("app.env", "dev", "开发环境"),
        ;

        private String key;
        private String value;
        private String remark;

        ConfigEnum(String key, String value, String remark) {
            this.key = key;
            this.value = value;
            this.remark = remark;
        }

        public String getKey() {
            return key;
        }

        public String getRemark() {
            return remark;
        }

        public String getValue() {
            return value;
        }

        /**
         * 获取免登录路径
         *
         * @return
         */
        private static String getNotLoginPath() {
            StringBuffer notLoginPath = new StringBuffer();
            notLoginPath.append("error")
                    .append("");
            if (APP_ENV.getValue().equals("dev")) {
                notLoginPath.append("")
                ;
            }
            return notLoginPath.toString();
        }
    }
}
