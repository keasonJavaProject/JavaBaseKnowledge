package com.test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class MyForkJoinPoolTest {
    public static void main(String[] args) {
        //创建ForkJoinPool
        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();
        ExecutorService executorService = Executors.newWorkStealingPool(8);
        ExecutorService executorServiceTwo = Executors.newWorkStealingPool();

        List list = Arrays.asList(() -> {
            Thread.sleep(3000);
            return 3;
        }, (Callable<Integer>) () -> {
            Thread.sleep(2000);
            return 2;
        });
        System.out.println("executorService invokeAll");
        System.out.println(LocalDateTime.now());
        List<Future> featureList = null;
        try {
            featureList = executorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        featureList.forEach(feature -> {
            try {
                System.out.println(feature.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        System.out.println(LocalDateTime.now());

    }
}
