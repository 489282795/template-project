package com.cn.template.common.bean.base;

import com.google.common.base.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "返回响应数据")
public class Response implements Serializable {
    private static final long serialVersionUID = 8350327877975282483L;

    @ApiModelProperty(value = "是否成功")
    private boolean success;

    @ApiModelProperty(value = "返回结果")
    private Object result;

    @ApiModelProperty(value = "状态编码")
    private String statusCode;

    @ApiModelProperty(value = "返回信息")
    private String message;

    public Response() {
    }

    public Response(Object result) {
        this.success = true;
        this.result = result;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    /**
     * 构造方法，根据flag返回不同结果
     *
     * @param flag   true|false
     * @param result 若flag=true，则返回result对象,若flag=false则返回errorCode
     */
    public Response(boolean flag, Object result) {
        if (flag) {
            this.success = true;
            this.result = result;
        } else {
            this.success = false;
            this.statusCode = (String) result;
        }
    }

    public Response(String statusCode) {
        this.success = false;
        this.statusCode = statusCode;
    }

    public Response(String statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        success = true;
        this.result = result;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.success = false;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Response response = (Response) o;
        if (success != response.success) {
            return false;
        }
        if (!statusCode.equals(response.statusCode)) {
            return false;
        }
        if (!result.equals(response.result)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result1 = (success ? 1 : 0);
        result1 = 31 * result1 + result.hashCode();
        result1 = 31 * result1 + statusCode.hashCode();
        return result1;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this).add("success", success).add("result", result).add("statusCode", statusCode)
                .add("message", message).omitNullValues().toString();
    }
}
