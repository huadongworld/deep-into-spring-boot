package com.ys.spring.reactive.loader;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author HuaDong
 * @date 2018/12/8 15:22
 *
 * {@link Future} 阻塞数据加载器
 */
public class FutureBlockingDataLoader extends DataLoader {

    @Override
    protected void doLoad() {

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        runCompletely(executorService.submit(super::loadConfigurations));
        runCompletely(executorService.submit(super::loadUsers));
        runCompletely(executorService.submit(super::loadOrders));
        executorService.shutdown();
    }

    private void runCompletely(Future<?> future) {
        try {
            //等待任务执行，能够使结果链式处理，但是另一方面又将原本并行处理变成了串行
            future.get();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new FutureBlockingDataLoader().load();
    }

}
