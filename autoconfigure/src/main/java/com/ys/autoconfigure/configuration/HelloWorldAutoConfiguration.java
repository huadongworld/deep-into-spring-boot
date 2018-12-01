package com.ys.autoconfigure.configuration;

import com.ys.autoconfigure.annotation.EnableHelloWorld;
import com.ys.autoconfigure.condition.ConditionalOnSystemProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuaDong
 * @date 2018/12/1 22:36
 *
 * HelloWorld 自动装配
 */
@Configuration // Spring 模式注解装配
@EnableHelloWorld // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "85176") // spring @Conditional 条件装配
public class HelloWorldAutoConfiguration {
}
