package com.cn.template.controller.base;

import com.cn.template.common.bean.base.ResourceBean;
import com.cn.template.common.bean.base.RoleMenusBean;
import com.cn.template.common.bean.base.SystemMenuBean;
import com.cn.template.service.base.SystemMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Api(tags = "角色权限管理")
@RestController
@RequestMapping("/template")
public class SystemMenuController {

    @Value("${api.resources.menu}")
    private String apiAuthUrl;

    @Value("${name}")
    private String serviceName;

    @Value("${is.open.api.auth}")
    private boolean isAuth;

    @Autowired
    private SystemMenuService systemMenuService;

    @ApiOperation(value = "VSL获取权限资源列表", produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/resources/{menuType}", method = {RequestMethod.GET})
    @ApiImplicitParam(value = "权限类型;0:按钮，1:菜单")
    public Object resources(@PathVariable(value="menuType") String menuType) {
        Integer type = 1;
        log.info("VSL获取权限资源列表的请求参数为:{}", type);
        log.info("keywords:{}",menuType);
        List<SystemMenuBean> menus = systemMenuService.getSystemMenu(type,menuType);
        String url=new StringBuilder(apiAuthUrl).append("/").append(menuType).append("/").toString();
        ResourceBean resourceBean = new ResourceBean(
        		menuType.toUpperCase().replace("-",""),
        		menuType.toUpperCase().replace("-",""),
        		url,
        		url,
                menus);
        log.info("返回的信息为:{}", resourceBean);
        return resourceBean;
    }

    @ApiOperation(value = "VSL获取角色的菜单权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(paramType = "path", name = "roleId", value = "角色ID", required = true)
    @RequestMapping(value = "resources/{menuType}/{roleId}", method = {RequestMethod.GET})
    public Object getSystemMenusByRole(@PathVariable(value = "menuType") String menuType,@PathVariable(value = "roleId") String roleId) {
        log.info("VSL获取角色的菜单权限的roleId为:{}", roleId);
        Map<String, List<SystemMenuBean>> map = new HashMap<String, List<SystemMenuBean>>(1);
        map.put("results", systemMenuService.getSystemMenuByMenuCodes(menuType,roleId));
        return map;
    }

    @ApiOperation(value = "VSL设置角色的菜单权限", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiImplicitParam(paramType = "path", name = "roleId", value = "角色ID", required = true)
    @RequestMapping(value = "resources/{menuType}/{roleId}", method = {RequestMethod.PUT})
    public void saveRolePrivilege(@PathVariable(value = "menuType") String menuType,@PathVariable(value = "roleId") String roleId, @RequestBody RoleMenusBean roleMenus) {
        log.info("子服务为:{}，将要保存的roleId为:{}，RoleMenusVO为:{}",menuType, roleId, roleMenus);
        systemMenuService.saveRolePrivilege(menuType,roleId, roleMenus.getRoleMenus(roleId));
    }


}