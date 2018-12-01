package com.ys.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @author HuaDong
 * @date 2018/12/1 20:30
 *
 * HelloWorld 配置
 */
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello World 2018";
    }

}
