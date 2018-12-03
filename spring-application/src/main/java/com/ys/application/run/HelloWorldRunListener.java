package com.ys.application.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author HuaDong
 * @date 2018/12/2 19:03
 *
 * HelloWorld {@link SpringApplicationRunListener}
 */
public class HelloWorldRunListener implements SpringApplicationRunListener {

    public HelloWorldRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        System.out.println("HelloWorldRunListener.starting()...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        System.out.println("HelloWorldRunListener.environmentPrepared()...");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        System.out.println("HelloWorldRunListener.contextPrepared()...");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        System.out.println("HelloWorldRunListener.contextLoaded()...");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        System.out.println("HelloWorldRunListener.started()...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        System.out.println("HelloWorldRunListener.running()...");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        System.out.println("HelloWorldRunListener.failed()...");
    }
}
