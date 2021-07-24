package com.cn.template.dao;

import com.cn.template.common.bean.base.SystemMenuBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemMenuMapper {

    /**
     * VSL获取权限资源列表
     * @param systemMenuBean
     * @return
     */
    public List<SystemMenuBean> getSystemMenu(SystemMenuBean systemMenuBean);

    /**
     *
     * @param list
     * @return
     */
    public List<SystemMenuBean> getSystemMenuByMenuCodes(@Param("list") List<String> list);




}
