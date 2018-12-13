package com.ys.autoconfigure.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author HuaDong
 * @date 2018/12/1 22:35
 *
 * {@link EnableAutoConfiguration} 引导类
 *
 * 自定义SpringBoot自动装配实现步骤：
 * 1.激活自动装配 @EnableAutoConfiguration
 * 2.实现自动装配 XXXAutoConfiguration
 * 3.配置自动装配实现 META-INF/spring.factories
 */
@EnableAutoConfiguration
public class EnableAutoConfigurationBootstrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableAutoConfigurationBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
