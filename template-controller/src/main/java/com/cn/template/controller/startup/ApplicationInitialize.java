package com.cn.template.controller.startup;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@Slf4j
public class ApplicationInitialize implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (event.getApplicationContext().getParent() == null) {
            log.info("程序初始化！");
        }
////        LocalServerUtil
//        new Thread(
//                new Runnable() {
//                    @Override
//                    public void run() {
//                        int i=0;
//                        while (i< 1000){
//                            log.info("程序已经启动！！");
//                            try {
//                                i++;
//                                LocalServerUtil.getLocalIp("127.0.0.1");
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                log.error("定时器异常！",e);
//                            }
//                        }
//                    }
//                }
//        ).start();
    }
}
