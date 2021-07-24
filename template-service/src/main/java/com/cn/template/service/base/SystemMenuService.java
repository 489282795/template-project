package com.cn.template.service.base;

import com.cn.template.common.bean.base.RolePrivilegeBean;
import com.cn.template.common.bean.base.SystemMenuBean;
import com.cn.template.dao.RolePrivilegeMapper;
import com.cn.template.dao.SystemMenuMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SystemMenuService {

	@Autowired
	private SystemMenuMapper systemMenuMapper;

	@Autowired
	private RolePrivilegeMapper rolePrivilegeMapper;

	/**
	 * VSL获取权限资源列表
	 *
	 * @param type
	 *            菜单类型
	 * @return
	 */
	public List<SystemMenuBean> getSystemMenu(Integer type, String keywords) {
		SystemMenuBean systemMenuBean = new SystemMenuBean();
		systemMenuBean.setStat(1);
		systemMenuBean.setIsMenu(type);
		systemMenuBean.setMenuName(keywords);
		log.info("VSL获取权限资源列表查询参数为:{}", systemMenuBean);
		List<SystemMenuBean> list = new ArrayList<>();
		try {
			list = systemMenuMapper.getSystemMenu(systemMenuBean);
		} catch (Exception e) {
			log.error("VSL获取权限资源列表出现异常:{}", e);
		}
		return list;
	}

	/**
	 * VSL根据角色id获取菜单
	 *
	 * @param roleId
	 * @return
	 */
	@Transactional
	public List<SystemMenuBean> getSystemMenuByMenuCodes(String menuType, String roleId) {
		log.info("VSL根据角色id获取菜单传入参数为:[menuType={},roleId={}]", menuType, roleId);
		List<SystemMenuBean> systemMenuBeanList = null;
		try {
			List<RolePrivilegeBean> rolePrivilegeList = rolePrivilegeMapper.getRolePrivilegeListByRoleId(menuType,
					roleId);
			log.info("VSL根据角色id获取到的菜单code为:{}", rolePrivilegeList);
			List<String> menuCodes = new ArrayList<>();
			if (null != rolePrivilegeList && 0 < rolePrivilegeList.size()) {
				for (RolePrivilegeBean rolePrivilege : rolePrivilegeList) {
					menuCodes.add(rolePrivilege.getMenuCode());
				}
			}
			log.info("VSL根据角色id获取menuCodes为:{}", menuCodes);
			systemMenuBeanList = systemMenuMapper.getSystemMenuByMenuCodes(menuCodes);
			log.info("VSL根据角色id获取systemMenuBeanList为:{}", systemMenuBeanList);
		} catch (Exception e) {
			log.error("根据roleId获取菜单出现异常:{}", e);
		}
		return systemMenuBeanList;
	}

	/**
	 * 菜单添加角色
	 *
	 * @param roleId
	 * @param rolePrivilegeList
	 */
	public void saveRolePrivilege(String menuType,String roleId, List<RolePrivilegeBean> rolePrivilegeList) {
		try {
			rolePrivilegeMapper.deleteRolePrivilege(menuType,roleId);
			log.info("角色对应的菜单删除成功！");
			if (null != rolePrivilegeList && 0 != rolePrivilegeList.size()) {
				rolePrivilegeMapper.insertRolePrivilege(rolePrivilegeList);
				log.info("菜单添加角色成功!");
			}
		} catch (Exception e) {
			log.error("菜单添加角色出现异常:{}", e);
		}
	}

}
