package com.ys.application;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author HuaDong
 * @date 2018/12/2 19:27
 *
 * Spring 应用上下文 引导类
 */
@SpringBootApplication
public class SpringApplicationContextBootstrap {

    public static void main(String[] args) {

        // 根据准备阶段的推断 Web 应用类型创建对应的 ConfigurableApplicationContext 实例
        ConfigurableApplicationContext context = new SpringApplicationBuilder(SpringApplicationContextBootstrap.class)
//                .web(WebApplicationType.NONE)
//                .web(WebApplicationType.REACTIVE)
                .run(args);

        System.out.println("ConfigurableApplicationContext 类型：" + context.getClass().getName());
        System.out.println("Environment 类型：" + context.getEnvironment().getClass().getName());

        // 关闭上下文
        context.close();
    }
}
