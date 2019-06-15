package com.lamba;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/2 16:48
 */
public class MyLambdaTwo {
    public static void main(String[] args) {
        //值转换
        List<MyEntity> myEntityList = Stream.of(new MyEntity(2, "2", Arrays.asList(new MyEntity(22, "22", null), new MyEntity(222, "222", null))),
                new MyEntity(1, "1", Arrays.asList(new MyEntity(11, "11", null), new MyEntity(111, "111", null))),
                new MyEntity(4, "2", Arrays.asList(new MyEntity(22, "22", null), new MyEntity(222, "222", null))),
                new MyEntity(3, "3", Arrays.asList(new MyEntity(33, "33", null), new MyEntity(333, "333", null), new MyEntity(33, "33", null))))
                .collect(Collectors.toList());
        List<Integer> one = Arrays.asList(1, 2, 3);
        List<Integer> Two = Arrays.asList(11, 22, 33);
        System.out.println("\n调用flatMap之前");//Stream<List<Integer>>
        System.out.println(Stream.of(one, Two).collect(Collectors.toList()));

        System.out.println("\n调用flatMap之后");//Stream<Integer>
        System.out.println(Stream.of(one, Two).flatMap(integers -> integers.stream()).collect(Collectors.toList()));


    }
}
