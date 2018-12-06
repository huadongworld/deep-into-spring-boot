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

    private final BlockingQueue<DeferredResult<String>> queue = new ArrayBlockingQueue<>(5);

    // 超时随机数
    private final Random random = new Random();

    @Scheduled(fixedRate = 5000)
    public void process() throws InterruptedException { // 定时操作
        DeferredResult<String> result = null;
        do {
            result = queue.take();
            // 随机超时时间
            long timeout = random.nextInt(100);
            // 模拟等待时间，RPC 或者 DB 查询
            Thread.sleep(timeout);
            // 计算结果
            result.setResult("Hello,World");
            println("执行计算结果，消耗：" + timeout + " ms.");
        } while (result != null);
    }

    @GetMapping("/hello-world")
    public DeferredResult<String> helloWorld() {

        //设置超时时间
        DeferredResult<String> result = new DeferredResult<>(50L);

        queue.offer(result);
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

    //================================================Callable实现=====================================================

    @GetMapping("/callable-hello-world")
    public Callable<String> callableHelloWorld() {

        final long startTime = System.currentTimeMillis();
        println("Hello,World");

        return () -> {
            long costTime = System.currentTimeMillis() - startTime;
            println("执行计算结果，消耗：" + costTime + " ms.");
            return "Hello,World";
        };
    }

}
