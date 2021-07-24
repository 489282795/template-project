package com.cn.template.common.bean.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description = "VSL对接菜单权限实体")
public class SystemMenuBean {

    @ApiModelProperty(value = "菜单ID")
    private String id;
    @ApiModelProperty(value = "菜单编码（根节点code为了不与之前系统使用的重复，请联系webapp的维护人员获取")
    private String menuCode;
    @ApiModelProperty(value = "父菜单编码")
    private String parentCode;
    @ApiModelProperty(value = "国际化字符串key")
    private String menuName;
    @ApiModelProperty(value = "菜单图标1")
    private String menuIcon1;
    @ApiModelProperty(value = "菜单图标2")
    private String menuIcon2;
    @ApiModelProperty(value = "菜单图标3")
    private String menuIcon3;
    @ApiModelProperty(value = "菜单的URL路径1")
    private String menuPath1;
    @ApiModelProperty(value = "菜单的URL路径2")
    private String menuPath2;
    @ApiModelProperty(value = "0:按钮，1：菜单")
    private Integer isMenu;
    @ApiModelProperty(value = "需要设置管理范围：0 无需数据权限，1 需要数据权限")
    private String isDataScope;
    @ApiModelProperty(value = "排序码,0,1,2,3,4…….")
    private String sort;
    @ApiModelProperty(value = "系统编号")
    private String systemCode;
    @ApiModelProperty(value = "服务名称，固定为大写的项目名称不可以修改")
    private String systemName;
    @ApiModelProperty(value = "状态，0 有效；1无效（此状态webapp不做校验，默认查出来的都是有效的菜单）")
    private Integer stat;
    @ApiModelProperty(value = "打开方式，0当前窗口；1 新窗口")
    private String openType;
    @ApiModelProperty(value = "菜单说明")
    private String menuTips;
    @ApiModelProperty(value = "标签")
    private String menuTag;
    @ApiModelProperty(value = "旧菜单编码")
    private String oldMenuCode;
    @ApiModelProperty(value = "备注")
    private String memo;



    @ApiModelProperty(value = "服务编码")
    private String serviceCode;
    @ApiModelProperty(value = "角色对应的权限获取地址")
    private String listUrl;
    @ApiModelProperty(value = "角色对应权限的设置地址")
    private String configAuthUrl;



}
