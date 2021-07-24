package com.cn.template.service.facade;

import com.cn.template.common.bean.base.Response;
import com.cn.template.common.bean.base.SysUserBean;

public interface SysUserService {

    public Response getUserInfo(SysUserBean sysUserBean);
}
