package com.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import static com.test.MyCompletableFutureTwoTest.waitLong;

public class MyReactorFluxPublishAndSubscribe {
    public static void main(String[] args) throws InterruptedException {
        /**
         * 在publishOn之前，所有的线程都是Thread-0,
         * publishOn之后都所有的线程都是是线程池线程
         */
        Scheduler s = Schedulers.newParallel("parallel-scheduler", 4);
        Hooks.onOperatorDebug();
        final Flux<String> flux = Flux
                .range(1, 2)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName() + "         1");
                })
                .map(i -> 10 + i)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName()+ "         2");
                })
                .publishOn(s)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName()+ "         3");
                })
                .map(i -> "value " + i)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName()+ "         4");
                });

        Thread thread = new Thread(() -> flux.subscribe(info->{
            System.out.println(Thread.currentThread().getName() + "         5");
            System.out.println(info);
        }));
        thread.start();
        thread.join();

        waitLong("111",4000L);




        System.out.println("===========================================================================================================================");

        /**
         * 所有的当前线程都是线程池线程
         */
        Scheduler ss = Schedulers.newParallel("parallel-scheduler", 4);
        final Flux<String> flux1 = Flux
                .range(1, 2)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName() + "         0");
                })
                .map(i -> 10 + i)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName() + "         1");
                })
                .subscribeOn(ss)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName() + "         2");
                })
                .map(i -> "value " + i)
                .doOnNext(integer -> {
                    System.out.println(Thread.currentThread().getName() + "         3");
                });

        Thread threadSecond =  new Thread(() -> flux1.subscribe(info -> {
            System.out.println(Thread.currentThread().getName() + "         4");
            System.out.println(info);
        }));
        threadSecond.start();
        threadSecond.join();
    }

}
