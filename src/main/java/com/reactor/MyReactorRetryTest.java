package com.reactor;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

import static com.test.MyCompletableFutureTwoTest.waitLong;

/**
 * reactive 重试测试
 *  {@link  "https://projectreactor.io/docs/core/release/reference/"}
 */
public class MyReactorRetryTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("\n\nFlux retryBackoff 不知道怎么用");


        fluxRetryWhen();

        FluxRepeat();

        FluxRetry();

    }

    private static void FluxRetry() {
        System.out.println("\n\nretry ,重复测试。 如果报异常重试不会被中断，仍然会执行第二次");
        Disposable disposable = Flux.interval(Duration.ofMillis(1000L))
                .map(info -> {
                    if (info > 1)
                        throw new RuntimeException(info + "");
                    return info;
                })
                .retry(1)
                .subscribe(System.out::println);
        waitLong("", 5000L);
        disposable.dispose();

    }




    private static void FluxRepeat() {
        System.out.println("\n\nrepeat 重复测试,如果报异常重试直接中断，不能执行第二次");
        Disposable disposable = Flux.interval(Duration.ofMillis(1000L))
                .map(info -> {
                    if (info > 1)
                        throw new RuntimeException(info + "");
                    return info;
                })
                .repeat(1)
                .subscribe(System.out::println);
        waitLong("", 5000L);
        disposable.dispose();

    }



    private static void fluxRetryWhen() {
        System.out.println("\n\nFlux retryWhen");
        Disposable disposable = Flux.interval(Duration.ofSeconds(1))
                .map(info -> {
                    if (info > 2) {
                        throw new IllegalStateException("IllegalStateException");
                    }
                    return info;
                })
                .retryWhen(throwableFlux -> throwableFlux.map(throwable -> {
                    if (throwable instanceof IllegalStateException) {
                        return Flux.just(12).subscribe(integer -> System.out.println("retry " + integer));
                    } else {
                        return Flux.just(22).subscribe(System.out::println);
                    }
                }))
                .subscribe(System.out::println);

                 waitLong("", 5000L);
                disposable.dispose();

    }


}
