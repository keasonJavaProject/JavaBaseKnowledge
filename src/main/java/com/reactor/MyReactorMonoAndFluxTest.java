package com.reactor;

import com.alibaba.fastjson.JSON;
import com.test.MyCompletableFutureTwoTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 并发请求返回结果
 * @see com.test.MyCompletableFutureTest
 * @see MyCompletableFutureTwoTest
 *  react 代码相关测试用例
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorMonoAndFluxTest {
    public static void main(String[] args) {
        Flux<Integer> ints = Flux.range(1, 3);
        ints.subscribe();

        System.out.println("并发返回多个结果testOneMono()");
        testOneMono();


        System.out.println("\n\n并发返回多个结果testManyFlux() ");
        testManyFlux();

    }


    /**
     * Publisher : flux 的例子
     *  an Asynchronous Sequence of 0-N Items
     */
    private static void testManyFlux() {
        Flux<CompletableFuture<String>> flux = Flux.just(CompletableFuture.supplyAsync(() -> {
                    MyCompletableFutureTwoTest.waitLong("testManyFlux One");
                    return "testManyFlux One";
                })
                , CompletableFuture.supplyAsync(() -> {
                    MyCompletableFutureTwoTest.waitLong("testManyFlux Two");
                    return "testManyFlux Two";
                }),
                CompletableFuture.supplyAsync(() -> {
                    MyCompletableFutureTwoTest.waitLong("testManyFlux three");
                    return "testManyFlux three";
                })
        );
        Mono<List<CompletableFuture<String>>> completableFutureMono = flux.collectList();
        Stream<CompletableFuture<String>> completableFutureStream = completableFutureMono.blockOptional().orElse(Collections.emptyList()).stream();
        System.out.println("testManyFlux listResults " + JSON.toJSONString(completableFutureStream.map(CompletableFuture::join).collect(Collectors.toList())));
    }


    /**
     *Publisher  : mono的例子
     * an Asynchronous 0-1 Result
     */
    private static void testOneMono() {
        System.out.println(new Date());
        Mono<String> mo1 = Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "1";
        }));
        Mono<Integer> mo2 = Mono.fromFuture(CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(4000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 2;
        }));


        Tuple2<String , Integer> tuple2 = Mono.zip(mo1, mo2).blockOptional().orElseGet(new Supplier<Tuple2<String, Integer>>() {
            @Override
            public Tuple2<String, Integer> get() {
                return null;
            }
        });
        System.out.println(tuple2.get(0) + "    " + tuple2.get(1));
        System.out.println(new Date());
    }


}
