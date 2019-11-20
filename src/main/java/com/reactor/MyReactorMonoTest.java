package com.reactor;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * 并发请求返回结果
 * @see com.test.MyCompletableFutureTest
 * @see com.test.MyCompletableFutureTwoTest
 *  react 代码相关测试用例
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorMonoTest {
    public static void main(String[] args) throws InterruptedException {
        Mono<Integer> integerMono = Mono.just(1);
        Mono<Integer> integerList = Mono.empty();
        Flux.interval(Duration.ofMillis(5000L))
                .map(executeTimes -> {
                    if (executeTimes < 1) return "executeTimes " + executeTimes+1;
                    throw new RuntimeException("boom");
                })
                .retry(1)
                .doOnNext(iiiii->{
                    System.out.println("++++++++++++++++++++++++++++++++++");
                })
                .elapsed()
                .subscribe(System.out::println, System.err::println);

        Thread.sleep(500000L);

    }


}
