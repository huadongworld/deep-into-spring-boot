package com.ys.spring.reactive.reactor;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HuaDong
 * @date 2018/12/9 11:07
 *
 * Flux 实例
 */
public class FluxDemo {

    public static void main(String[] args) {

        println("运行...");
        // 发布 A -> B -> C
        Flux.just("A", "B", "C")
                // 线程池切换
                .publishOn(Schedulers.elastic())
                // "A" -> "+" 转换
                .map(value -> "+" + value)

//                // Lambda方式
//                .subscribe(
//                        // 数据消费 = onNext(T)
//                        FluxDemo::println,
//                        // 异常处理 = onError(Throwable)
//                        FluxDemo::println,
//                        // 完成回调 = onComplete()
//                        () -> println("完成操作！"),
//                        // 背压操作 = onSubscribe(Subscription)
//                        subscription -> {
//                            // n 请求的元素数量
//                            subscription.request(Integer.MAX_VALUE);
//                            // 取消上游传输数据到下游
//                            subscription.cancel();
//                        }
//                )

                // 匿名内部类的方式
                .subscribe(new Subscriber<String>() {

                    private Subscription subscription;

                    private int count = 0;

                    @Override
                    public void onSubscribe(Subscription s) {
                        subscription = s;
                        subscription.request(1);
                    }

                    @Override
                    public void onNext(String s) {
                        if(count==2){
                            throw new RuntimeException("故意抛异常！");
                        }
                        println(s);
                        count++;
                        subscription.request(1);
                    }

                    @Override
                    public void onError(Throwable t) {
                        println(t.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        println("完成操作！");
                    }
                })
        ;

    }

    private static void println(Object object) {
        String threadName = Thread.currentThread().getName();
        System.out.println("[线程：" + threadName + "] " + object);
    }

    /**
     * Reactive Streams 与 Java 8 Stream 的区别 ：
     * Spring Reactor 的 API 看上去和 Java 8 Stream 很像，但是实现原理有很大的差别
     * 前者是一种 Push-based模式，而后者是Pull-based的模式，
     * Pull 模式对应的是同步的、命令式的程序（使用的是Iterator模式），Push 模式对应的是异步的、非阻塞的、响应式的程序（使用的观察者模式）
     */
    @Test
    public void demo() {

        //Java8 Stream API
        Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k")
                .stream()
                .parallel()
                .forEach(FluxDemo::println);
    }
}
