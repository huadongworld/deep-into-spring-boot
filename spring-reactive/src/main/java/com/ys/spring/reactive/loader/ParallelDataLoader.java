package com.ys.spring.reactive.loader;

import java.util.concurrent.*;

/**
 * @author HuaDong
 * @date 2018/12/6 22:07
 *
 * 并行数据加载器
 */
public class ParallelDataLoader extends DataLoader {

    /**
     * 并行计算
     */
    @Override
    protected void doLoad() {

        // 创建线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        CompletionService completionService = new ExecutorCompletionService(executorService);
        //  耗时 >= 1s
        completionService.submit(super::loadConfigurations, null);
        //  耗时 >= 2s
        completionService.submit(super::loadUsers, null);
        //  耗时 >= 3s
        completionService.submit(super::loadOrders, null);

        // 等待三个任务完成
        int count = 0;
        while (count < 3) {
            if (completionService.poll() != null) {
                count++;
            }
        }
        executorService.shutdown();
    }// 总耗时 max(1s, 2s, 3s)  >= 3s

    public static void main(String[] args) {
        new ParallelDataLoader().load();
    }

}
