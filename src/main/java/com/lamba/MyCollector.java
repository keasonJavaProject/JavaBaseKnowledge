package com.lamba;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/2 15:33
 */
public class MyCollector {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(-1, 1, 2, 3, 4, 1, 1, 2).collect(Collectors.toList());
        System.out.println(list.stream().filter(i -> i > 2).collect(Collectors.toList()));
        System.out.println(list.stream().collect(Collectors.toSet()));
        //平均值
        System.out.println(list.stream().collect(Collectors.averagingInt(i -> i)));
        //求和
        System.out.println(list.stream().collect(Collectors.summingInt(i -> i)));
        //最小值
        System.out.println(list.stream().collect(Collectors.minBy(Comparator.comparing(i -> i))).get());

        //奇数偶数分组
        System.out.println(list.stream().collect(Collectors.partitioningBy(i -> i % 2 == 0)));

        //joining
        System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        System.out.println(list.stream().allMatch(i -> i < 10));
        System.out.println(list.stream().anyMatch(i -> i < 3));

        System.out.println(list.stream().findFirst().get());
        System.out.println(list.stream().findFirst().get());


        System.out.println(list.stream().sorted().collect(Collectors.toList()));

    }

}
