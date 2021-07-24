package com.cn.template.controller.startup;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.cn.template")
@ImportResource({"classpath:spring-main.xml"})
@SpringBootApplication(exclude = {SpringDataWebAutoConfiguration.class})
public class ApplicationStartup {

    /**
     * 程序启动入口
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ApplicationStartup.class, args);
    }
}