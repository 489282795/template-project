package com.cn.template.common.bean.base;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@ApiModel(description = "VSL对接菜单权限实体")
public class RolePrivilegeBean {

    /**
     * ID
     */
	private Long id;
    /**
     * 角色ID
     */
	private String roleId;
    /**
     * 菜单编码
     */
	private String menuCode;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuCode() {
		return menuCode;
	}

	public void setMenuCode(String menuCode) {
		this.menuCode = menuCode;
	}

	public RolePrivilegeBean() {
	}

	public RolePrivilegeBean(String roleId, String menuCode) {
		this.roleId = roleId;
		this.menuCode = menuCode;
	}
}
