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
        List<Integer> one = Arrays.asList(1, 2, 3);
        List<Integer> Two = Arrays.asList(11, 22, 33);
        System.out.println("\n调用flatMap之前");//Stream<List<Integer>>
        System.out.println(Stream.of(one, Two).collect(Collectors.toList()));

        System.out.println("\n调用flatMap之后");//Stream<Integer>
        System.out.println(Stream.of(one, Two).flatMap(integers -> integers.stream()).collect(Collectors.toList()));

        //值转换
        List<MyEntity> myEntityList = Stream.of(new MyEntity(2, "2", Arrays.asList(new MyEntity(22, "22", null), new MyEntity(222, "222", null))),
                new MyEntity(1, "1", Arrays.asList(new MyEntity(11, "11", null), new MyEntity(111, "111", null))),
                new MyEntity(4, "2", Arrays.asList(new MyEntity(22, "22", null), new MyEntity(222, "222", null))),
                new MyEntity(3, "3", Arrays.asList(new MyEntity(33, "33", null), new MyEntity(333, "333", null), new MyEntity(33, "33", null))))
                .collect(Collectors.toList());


        System.out.println("Collectors.groupingBy Name");
        Map<String, List<MyEntity>> myMapEntity = myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
            @Override
            public String apply(MyEntity myEntity) {
                return myEntity.getName();
            }
        }));
        System.out.println(JSON.toJSONString(myMapEntity));



        System.out.println("\nCollectors.groupingBy summingInt");
        Map mapIdSumListIds = myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
            @Override
            public String apply(MyEntity myEntity) {
                return myEntity.getName();
            }
        }, Collectors.summingInt(new ToIntFunction<MyEntity>() {
            @Override
            public int applyAsInt(MyEntity value) {
                return value.getList().stream().mapToInt(in -> in.getId()).sum();
            }
        })));
        System.out.println(JSON.toJSONString(mapIdSumListIds));


        System.out.println("\n groupingBy averagingDouble");
        mapIdSumListIds = myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
            @Override
            public String apply(MyEntity myEntity) {
                return myEntity.getName();
            }
        }, Collectors.averagingDouble(new ToDoubleFunction<MyEntity>() {
            @Override
            public double applyAsDouble(MyEntity value) {
                return value.getList().stream().mapToDouble(in -> in.getId()).sum();
            }
        })));
        System.out.println(JSON.toJSONString(mapIdSumListIds));

        System.out.println("\n groupingBy Collectors.mapping");
        mapIdSumListIds = myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
            @Override
            public String apply(MyEntity myEntity) {
                return myEntity.getName();
            }
        }, Collectors.mapping(new Function<MyEntity, Double>() {

            @Override
            public Double apply(MyEntity myEntity) {
                return Double.valueOf(myEntity.getList().stream().mapToInt(info -> info.getId()).sum());
            }
        }, Collectors.averagingDouble(in -> in))));
        System.out.println(JSON.toJSONString(mapIdSumListIds));

    }
}
