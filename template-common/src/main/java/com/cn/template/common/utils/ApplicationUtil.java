package com.cn.template.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    /**
     * 加载spring配置文件时，如果spring配置文件中所定义的Bean类实现了ApplicationContextAware接口，会自动调用该方法
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException{
        this.applicationContext = applicationContext;
    }

    /**
     * 获取spring上下文
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 获取spring中Bean
     * @param name
     * @return
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException{
        return applicationContext.getBean(name);
    }
}
