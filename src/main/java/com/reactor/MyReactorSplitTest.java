package com.reactor;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static com.test.MyCompletableFutureTwoTest.waitLong;

/**
 * 并发请求返回结果
 * @see com.test.MyCompletableFutureTest
 * @see com.test.MyCompletableFutureTwoTest
 *  react 代码相关测试用例
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorSplitTest {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("\n\nFlux.range(1, 20).buffer(3)");
        Disposable disposable = Flux.range(1, 20)
                .buffer(3)
                .doOnNext(System.out::println)
                .subscribe(integers -> System.out.println(integers.stream().mapToInt(Integer::intValue).sum() + "\n"));
        waitLong("", 5000L);
        disposable.dispose();


        System.out.println("\n\nFlux.range(1, 20).groupBy(integer -> integer % 4)");
        disposable = Flux.range(1, 20)
                .groupBy(integer -> integer % 4)
                .subscribe(integerIntegerGroupedFlux ->{
                    System.out.println(integerIntegerGroupedFlux.key());
                    integerIntegerGroupedFlux.collectList().subscribe(System.out::println);
                });
        waitLong("", 5000L);
        disposable.dispose();


        System.out.println("\n\n滑动窗口 Flux.range(1, 20).window(4, 1)");
        disposable = Flux.range(1, 20)
                .window(4, 1)
                .subscribe(new Consumer<Flux<Integer>>() {
                    @Override
                    public void accept(Flux<Integer> integerFlux) {
                        integerFlux.collectList().subscribe(System.out::println);
                    }
                });
        waitLong("", 5000L);
        disposable.dispose();



    }


}
