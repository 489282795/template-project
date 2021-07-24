package com.cn.template.dao;

import com.cn.template.common.bean.base.RolePrivilegeBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePrivilegeMapper {

	/**
	 * 根据角色id获取菜单code
	 *
	 * @param roleId
	 * @return
	 */
	public List<RolePrivilegeBean> getRolePrivilegeListByRoleId(@Param("menuType") String menuType,
                                                                @Param("roleId") String roleId);

	public boolean deleteRolePrivilege(@Param("menuType") String menuType, @Param("roleId") String roleId);

	public void insertRolePrivilege(List<RolePrivilegeBean> rolePrivilegeList);

}
