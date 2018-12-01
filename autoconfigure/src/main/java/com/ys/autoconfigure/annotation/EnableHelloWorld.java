package com.ys.autoconfigure.annotation;

import com.ys.autoconfigure.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author HuaDong
 * @date 2018/12/1 20:31
 *
 * 激活 HelloWorld 模块
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class) //注解驱动方式
@Import(HelloWorldImportSelector.class) //接口编程方式：比较有弹性
public @interface EnableHelloWorld {
}
