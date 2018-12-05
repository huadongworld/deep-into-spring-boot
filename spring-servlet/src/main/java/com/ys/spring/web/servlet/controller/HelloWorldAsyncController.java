package com.ys.spring.web.servlet.controller;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.Random;
import java.util.concurrent.*;

/**
 * @author HuaDong
 * @date 2018/12/5 21:27
 *
 * Hello World 异步 {@link RestController}
 */
@RestController
@EnableScheduling
public class HelloWorldAsyncController {

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {

        //设置超时时间
        DeferredResult<String> result = new DeferredResult<>(50L);

        println("Hello,World");

        //线程结束执行
        result.onCompletion(() -> {
            println("执行结束");
        });

        //超时回调
        result.onTimeout(() -> {
            println("执行超时");
        });

        return result;
    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("HelloWorldAsyncController[" + threadName + "]: " + object);
    }

}
