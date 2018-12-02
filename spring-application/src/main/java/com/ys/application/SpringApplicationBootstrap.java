package com.ys.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.security.auth.login.Configuration;
import java.util.HashSet;
import java.util.Set;

/**
 * @author HuaDong
 * @date 2018/12/2 12:02
 *
 * java配置class 或者XML 上下文配置集合，用于SpringBoot BeanDefinitionLoader读取，
 *
 * 并且将配置源解析加载为Spring Bean定义
 */
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class, args);

        Set<String> sources = new HashSet<>();
        // 配置Class 名称
        sources.add(ApplicationConfiguration.class.getName());
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
//        springApplication.setWebApplicationType(WebApplicationType.NONE);
        ConfigurableApplicationContext context = springApplication.run(args);
//        System.out.println("Bean : " + context.getBean(ApplicationConfiguration.class));
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
