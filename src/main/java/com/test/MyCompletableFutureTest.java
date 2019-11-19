package com.test;

import com.reactor.MyReactorMonoTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;

/**
 *  通过 Reactor Mono实现的并发获取结果
 * @see MyReactorMonoTest
 */
public class MyCompletableFutureTest {
    public static void main(String[] args) {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 2;
        });

        //调用方法
        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //调用方法之后，会调用
        completableFuture.whenComplete(new BiConsumer<Integer,Throwable>() {
            @Override
            public void accept(Integer o, Throwable o2) {
                System.out.println(o);
                System.out.println(o2);
            }
        });


        System.out.println("\r\n 异常测试");
        completableFuture = CompletableFuture.supplyAsync(() -> {
                return 1 / 0;
        });
        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //调用方法之后，会调用
        completableFuture.whenComplete(new BiConsumer<Integer,Throwable>() {
            @Override
            public void accept(Integer o, Throwable o2) {
                System.out.println(o);
                System.out.println(o2);
            }
        });

    }
}
