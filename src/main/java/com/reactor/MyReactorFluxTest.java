package com.reactor;

import reactor.core.publisher.Flux;

import java.util.function.Function;

/**
 * 并发请求返回结果
 * @see com.test.MyCompletableFutureTest
 * @see com.test.MyCompletableFutureTwoTest
 *  react 代码相关测试用例
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorFluxTest {
    public static void main(String[] args) {
        System.out.println("Flux.just(1, 2, 3) collectList().block()");
        Flux<Integer> integerFLux = Flux.just(1, 2, 3);
        System.out.println(integerFLux.collectList().block());

        System.out.println("\n\nFlux.just(1, 2, 3) subscribe");
        integerFLux.subscribe(info -> System.out.println(info.intValue()));



        System.out.println("\n\nFlux.range(1, 10) collectList().block()");
        Flux<Integer> integerRangeFLux = Flux.range(1, 10);
        System.out.println(integerRangeFLux.collectList().block());

        System.out.println("\n\nFlux.range(1, 10) subscribe");
        integerRangeFLux.subscribe(info -> System.out.println(info.intValue()));


        System.out.println("\n\nFlux.range(1, 10) gtFiveExp exception");
        Flux<Integer> gtFiveExp = integerRangeFLux.map(integer -> {
            if (integer > 5)
                throw new IllegalStateException("gt 5 exception");
            return integer;
        }).onErrorReturn(-1);
        gtFiveExp.subscribe(integer -> System.out.println(integer), error->{
            System.out.println(error.getMessage());
        });


        System.out.println("\n\nFlux.range(1, 10) gtFiveExp exception with complete");
        integerRangeFLux.subscribe(integer -> System.out.println(integer), error->{
            System.out.println(error.getMessage());
        },()->{
            System.out.println("Done");
        });
    }


}
