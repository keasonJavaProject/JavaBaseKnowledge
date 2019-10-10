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


        //Arrays.copyOf()方法主要是为了给原有数组扩容
        System.out.println("\n\nArrays.copyOf(a, 10),把大小为3的数组，扩容为10 ");
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        int[] b = Arrays.copyOf(a, 10);
        System.out.println(JSON.toJSONString(b));


        System.out.println("\n\nSystem.arraycopy(arr, 2, arr, 3, 3)");
        int[] arr = new int[10];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        //[0,1,2,3,0,0,0,0,0,0]
        System.out.println("before System.arraycopy " + JSON.toJSONString(arr));

        // [0,1,2,3,0,0,0,0,0,0]  第2个位置期Copy3个（即：2,3,0），
        // [*,*,*,2,3,0,*,*,*,*]
        // [0,1,2,2,3,0,0,0,0,0] 最终结果
        System.arraycopy(arr, 2, arr, 3, 3);
        System.out.println("after System.arraycopy " + JSON.toJSONString(arr));


        //[0,1,2,2,3,0,0,0,0,0]  >> [0,1,99,2,3,0,0,0,0,0]
        arr[2]=99;
        System.out.println("after change arr[2]=99 " + JSON.toJSONString(arr));



    }
}
