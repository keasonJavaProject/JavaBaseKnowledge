package com.reactor;

import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 并发请求返回结果
 * @see com.test.MyCompletableFutureTest
 * @see com.test.MyCompletableFutureTwoTest
 *  react 代码相关测试用例
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorMonoTest {
    public static void main(String[] args) {
        Mono<Integer> integerMono = Mono.just(1);
        Mono<Integer> integerList = Mono.empty();

    }


}
