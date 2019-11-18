package com.test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyCompletableFutureTwoTest {
    private static ExecutorService executorService = Executors.newFixedThreadPool(8);
    public static void main(String[] args) throws Exception {
        //构造函数  有返回值、没返回值、直接给值
        CompletableFuture giveValue = CompletableFuture.completedFuture(1);
        CompletableFuture completableFutureSupply = CompletableFuture.supplyAsync(() ->waitLong("completableFutureSupply"));
        CompletableFuture completableFutureRun = CompletableFuture.runAsync(() -> waitLong("completableFutureRun"));

        //所有的都完成
        System.out.println("CompletableFuture.allOf");
        System.out.println(LocalDateTime.now());
        CompletableFuture allResult = CompletableFuture.allOf(giveValue, completableFutureRun, completableFutureSupply);
        try {
            System.out.println(allResult.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(LocalDateTime.now());


        //取得所有结果
        System.out.println("CompletableFuture.allOf 取得所有结果,同一个stream，先用Array进行计算，然后再收集stream结果");
        CompletableFuture future1=  CompletableFuture.supplyAsync(() ->{waitLong("first One");return "first One";});
        CompletableFuture future2= CompletableFuture.supplyAsync(()->{waitLong("second One");return "second One";});
        CompletableFuture future3=  CompletableFuture.supplyAsync(()->{waitLong("second One");return "second One";});
        //转化为stream
        Stream<CompletableFuture<String>> completableFutureStream = Stream.of(future1, future2, future3);

        //stream 转成List
        List<CompletableFuture<String>> completableFutureList = completableFutureStream.collect(Collectors.toList());

        //list 转成Array
        CompletableFuture<String>[] completableFuturesArray = completableFutureList.toArray(new CompletableFuture[completableFutureList.size()]);

        CompletableFuture<Void> completableFutureResult = CompletableFuture.allOf(completableFuturesArray);
        completableFutureResult.join();

        System.out.println(completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList()));




        //任一一个完成,取最快完成的那个
        System.out.println("\n\nCompletableFuture.anyOf");
        allResult = CompletableFuture.anyOf(giveValue, completableFutureRun, completableFutureSupply);
        try {
            System.out.println(allResult.get());;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //执行完成调用
        System.out.println("\nallResult.whenComplete");
        allResult.whenComplete((object, object2) -> System.out.println("done"));


        System.out.println("\nthenCombineAsync 等待2个结果都完成，然后再进行计算");
        CompletableFuture firstOne = CompletableFuture.supplyAsync(() -> waitLong("thenCombineAsync first"), executorService);
        //有返回结果 firstOne.thenCombine(null,null) 计算结果;         firstOne.thenCombineAsync(null,null) 使用ForkJoinPool;         firstOne.thenCombineAsync(null,null,null)  使用自定义线程池
        //没有返回结果 firstOne.thenAcceptBoth()
        CompletableFuture completableFutureFirstOCombine= firstOne.thenCombineAsync(CompletableFuture.supplyAsync(() -> waitLong("thenCombineAsync second"), executorService), new BiFunction<Integer,Integer,Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                int temp = waitLong("thenCombineAsync BiFunction");
                return integer + integer2 + temp;
            }
        });
        System.out.println(completableFutureFirstOCombine.get());

        System.out.println("\napplyToEither 返回执行最快的那个"); // 类似接口 first.applyToEither(); first.acceptEither()，区别在于是否有返回值
        CompletableFuture first = CompletableFuture.supplyAsync(() -> waitLong("applyToEither first"),executorService);
        CompletableFuture completableFutureFirst = first.applyToEitherAsync(CompletableFuture.supplyAsync(() -> waitLong("applyToEither second"),executorService), (Function<Integer, Integer>) integer -> integer + 1);
        System.out.println(completableFutureFirst.get());


        System.out.printf("\nthenApply 相当于map value");
        CompletableFuture<Integer> firstThenApplyOne = CompletableFuture.supplyAsync(() -> waitLong("thenApply first"),executorService);
        CompletableFuture<Double> firstThenApplyTwo = firstThenApplyOne.thenApply(new Function<Integer, Double>() {
            @Override
            public Double apply(Integer integer) {
                return Double.valueOf(integer.toString());
            }
        });
        System.out.println(firstThenApplyTwo.get());

        System.out.printf("\nthenCompose 相当于重建新的CompletableFuture");
        CompletableFuture<Integer> firstThenComposeOne = CompletableFuture.supplyAsync(() -> waitLong("thenCompose first"),executorService);
        CompletableFuture<Double> firstThenComposeTwo = firstThenComposeOne.thenCompose(new Function<Integer, CompletionStage<Double>>() {
            @Override
            public CompletionStage<Double> apply(Integer integer) {
                return CompletableFuture.completedFuture(Double.parseDouble(integer.toString()));
            }
        });
        System.out.println(firstThenComposeTwo.get());

    }

    public static int waitLong(String sout) {
        try {
            Random random = new Random();
            System.out.println(sout + " start time = " + LocalDateTime.now());
            int temp = (random.nextInt(100) + 1) * 30;
            Thread.sleep(temp);
            System.out.println(sout + " temp = " + temp + "  time    " + LocalDateTime.now());
            return temp;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
