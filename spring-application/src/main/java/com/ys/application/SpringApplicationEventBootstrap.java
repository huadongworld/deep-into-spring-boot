package com.ys.application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author HuaDong
 * @date 2018/12/2 18:48
 *
 * Spring 应用事件监听引导类
 */
public class SpringApplicationEventBootstrap {

    public static void main(String[] args) {

        // 创建上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

        // 注册应用事件监听器 能够监听到以下五个事件
        context.addApplicationListener(event -> System.out.println("监听到事件: " + event));

        // 启动上下文
        context.refresh();

        // 发送事件
        context.publishEvent("HelloWorld");
        context.publishEvent("2018");
        context.publishEvent(new ApplicationEvent("大圣") {});

        // 关闭上下文
        context.close();
    }
}
