package com.ys.autoconfigure.bootstrap;

import com.ys.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author HuaDong
 * @date 2018/12/1 21:09
 *
 * 系统属性条件引导类
 */
//@ConditionalOnSystemProperty(name = "user.name", value = "85176")
public class ConditionalOnSystemPropertyBootstrap {

    /**
     * 只有当配置的这个系统属性条件: @ConditionalOnSystemProperty(name = "user.name", value = "85176") 生效时才会加载bean
     */
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "85176")
    public String helloWorld() {
        return "Hello world!";
    }

    public static void main(String[] args) {

        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld Bean : " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
