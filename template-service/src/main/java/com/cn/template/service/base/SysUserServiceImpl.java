package com.cn.template.service.base;

import com.cn.template.common.bean.base.Response;
import com.cn.template.common.bean.base.SysUserBean;
import com.cn.template.common.enums.ErrorEnum;
import com.cn.template.dao.SysUserMapper;
import com.cn.template.service.facade.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Component
public class SysUserServiceImpl extends BaseService implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public Response getUserInfo(SysUserBean sysUserBean) {
        log.info("进入用户信息查询接口：{}", sysUserBean);
        List<SysUserBean> getUserInfo = null;
        try {
            getUserInfo = sysUserMapper.getUserInfo(sysUserBean);
            if (getUserInfo.isEmpty()) {
                return response(ErrorEnum.ERROR_0001);
            }
        } catch (Exception e) {
            log.error("查询用户信息出现异常：{}", e);
            return response(ErrorEnum.ERROR_0002);
        }
        return response(getUserInfo);
    }
}
