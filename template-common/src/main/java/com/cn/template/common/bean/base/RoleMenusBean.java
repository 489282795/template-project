package com.cn.template.common.bean.base;

import lombok.ToString;
import org.apache.commons.lang.StringUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@ToString
public class RoleMenusBean {

    private List<MenuCode> menus;

    static class MenuCode {
        private String menuCode;

        public String getMenuCode() {
            return menuCode;
        }

        public void setMenuCode(String menuCode) {
            this.menuCode = menuCode;
        }

        @Override
        public String toString() {
            return "[menuCode=" + menuCode + "]";
        }

    }

    public List<RolePrivilegeBean> getRoleMenus(String roleId) {
        if (roleId != null && !CollectionUtils.isEmpty(menus)) {
            List<RolePrivilegeBean> rolePrivileges = new ArrayList<RolePrivilegeBean>(menus.size());
            RolePrivilegeBean temp = null;
            for (MenuCode rolePrivilege : menus) {
                if (StringUtils.isNotEmpty(rolePrivilege.getMenuCode())) {
                    temp = new RolePrivilegeBean(roleId, rolePrivilege.getMenuCode());
                    rolePrivileges.add(temp);
                }
            }
            return rolePrivileges;
        }
        return null;
    }

    public List<MenuCode> getMenus() {
        return menus;
    }

    public void setMenus(List<MenuCode> menus) {
        this.menus = menus;
    }


}
