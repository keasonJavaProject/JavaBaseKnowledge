package com.test;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyArraysTest {
    public static void main(String[] args) {

        System.out.println(" Arrays.asList(数组) 数组必须是包装类");
        int[] ints = {1, 2, 3};
        List one = Arrays.asList(ints);
        System.out.println(" Arrays.asList(ints) ");
        one.stream().forEach(info -> System.out.println(JSON.toJSONString(one)));

        Integer[] integers = {1, 2, 3};
        List two = Arrays.asList(integers);
        System.out.println("\n\nArrays.asList(integers) ");
        two.stream().forEach(info -> System.out.println(info));


        System.out.println("\n\nStream.of(1, 2, 3)生成数组");
        Stream.of(1, 2, 3).collect(Collectors.toList()).forEach(info -> System.out.println(info));


        System.out.println("\n\nlist.toArray(new String[0]) 需要指定类型,默认的toArray()方法，是Object类型");
        String [] s= new String[]{
                "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
        };
        List<String> list = Arrays.asList(s);
        Collections.reverse(list);
        s=list.toArray(new String[0]);//没有指定类型的话会报错
        System.out.println(JSON.toJSONString(s));


    }
}
