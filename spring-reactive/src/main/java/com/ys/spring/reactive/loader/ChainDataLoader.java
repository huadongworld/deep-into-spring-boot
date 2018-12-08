package com.ys.spring.reactive.loader;

import java.util.concurrent.CompletableFuture;

/**
 * @author HuaDong
 * @date 2018/12/8 15:45
 *
 * 链式数据加载器
 */
public class ChainDataLoader extends DataLoader {

    @Override
    protected void doLoad() {

        // main -> submit -> ...
        // sub-thread : F1 -> F2 -> F3
        CompletableFuture
                .runAsync(super::loadConfigurations)
                .thenRun(super::loadUsers)
                .thenRun(super::loadOrders)
                .whenComplete((result, throwable) -> {
                    // 完成时回调
                    System.out.println("[线程 ：" + Thread.currentThread().getName() + "] 加载完成");
                })
                .exceptionally(throwable->{
                    System.out.println("[线程 ：" + Thread.currentThread().getName() + "] 加载异常");
                    return null;
                })
                .join(); // 等待完成
    }

    public static void main(String[] args) {
        new ChainDataLoader().load();
    }
}
