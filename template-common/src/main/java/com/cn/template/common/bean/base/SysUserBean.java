package com.cn.template.common.bean.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description = "用户信息实体")
public class SysUserBean extends BaseBean{

    @ApiModelProperty(value = "主键Id")
    private String id;
    @ApiModelProperty(value = "归属公司")
    private String email;
    @ApiModelProperty(value = "归属部门")
    private String createtime;
    @ApiModelProperty(value = "登录名")
    private String password;
    @ApiModelProperty(value = "密码")
    private String type;
    @ApiModelProperty(value = "工号")
    private String nickname;
    @ApiModelProperty(value = "姓名")
    private String avatar;
    @ApiModelProperty(value = "邮箱")
    private String status;
}
