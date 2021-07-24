package com.cn.template.dao;


import com.cn.template.common.bean.base.SysUserBean;

import java.util.List;

public interface SysUserMapper {

    public List<SysUserBean> getUserInfo(SysUserBean sysUserBean);
}
