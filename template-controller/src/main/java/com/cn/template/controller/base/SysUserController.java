package com.cn.template.controller.base;

import com.cn.template.common.bean.base.Response;
import com.cn.template.common.bean.base.SysUserBean;
import com.cn.template.service.facade.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Api(                                       //将类标记为swagger资源
        value = "该注解没有实际的使用意义", //该注解没有实际的使用意义，在UI中也看不到
        tags = "用户信息模块")              //说明该类的作用，可以在UI界面上看到的注解
@RestController
@RequestMapping("/base")
public class SysUserController {
    private static Logger log = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    @ApiOperation(                                         //该注解用在请求的方法上，说明方法的用途、作用
            value = "获取用户信息",                        //说明方法的用途、作用
            notes = "该接口用于获取一些用户相关的信息！")  //方法的备注说明
    @ApiImplicitParam(                                     //指定请求参数的信息
            name="sysUserBean",                            //参数名
            value = "用户信息实体" ,                       //参数的说明/解释
            required = true ,                              //参数是否必传
            dataType = "SysUserBean",                      //参数类型，默认是String
            defaultValue = "SysUserBean")                  //参数默认值
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/getUserInfo",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public Response getUserInfo(@RequestBody SysUserBean sysUserBean) {
        log.info("请求到了Controller层");
        return sysUserService.getUserInfo(sysUserBean);
    }

    @ApiOperation(
            value = "删除用户信息",
            notes = "该接口用来删除用户信息！")
    @ApiImplicitParam(
            name="sysUserBean",
            value = "用户信息实体" ,
            required = true ,
            dataType = "SysUserBean")
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/deleteUserInfo",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8",
            headers = "Accept=application/json")
    @ResponseStatus(HttpStatus.OK)
    public Response deleteUserInfo(@RequestBody SysUserBean sysUserBean) {
        log.info("开始删除用户信息!");
        return new Response();
    }

}
