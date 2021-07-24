package com.cn.template.common.bean.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.Assert;

import java.io.Serializable;

@Getter
@Setter
@ToString
@ApiModel(description = "基类实体")
public class BaseBean implements Serializable {

    @ApiModelProperty(value = "分页页码")
    private Integer pageIndex = 0;

    @ApiModelProperty(value = "分页大小(pageIndex*pageSize)")
    private Integer pageSize = 5;

    @ApiModelProperty(value = "排序 升序:asc 降序:desc")
    private String sort;

    @ApiModelProperty(value = "排序字段")
    private String order;

    @ApiModelProperty(value = "分组")
    private String group;

    @ApiModelProperty(value = "请求时间(yyyy-MM-dd hh:mm:ss)")
    private String reqTime;

    @ApiModelProperty(value = "MD5校验值")
    private String requestSystem;

    void check() {
        Assert.notNull(reqTime, "请求时间不能为空");
        Assert.notNull(requestSystem, "MD5校验值不能为空");
    }

    public Integer getPageIndex() {
        if (pageIndex <= 0) {
            pageIndex = 1;
        }
        return (pageIndex - 1) * pageSize;
    }
}
