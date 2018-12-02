package com.lamba;

import com.util.sort.SortUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/2 16:48
 */
public class MyOptional {
    public static void main(String[] args) {
        List<MyEntity> myEntityList = Stream.of(new MyEntity(1, "2"), new MyEntity(2, "2"), null).collect(Collectors.toList());
        System.out.println("比较2个list 大小");
        System.out.println(myEntityList.stream().collect(Collectors.toList()).size());
        System.out.println(myEntityList.stream().filter(i -> i != null).collect(Collectors.toList()).size());

        System.out.println("三种方式实现取得name list");
        //循环list中的对象，通过optional 避免空指针异常 来取 name
        try {
            System.out.println(myEntityList.stream().map(i -> i.getName()).collect(Collectors.toList()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        //过滤掉null的对象
        System.out.println(myEntityList.stream().filter(i -> i != null).map(i -> i.getName()).collect(Collectors.toList()));

        System.out.println(myEntityList.stream().map(i -> Optional.ofNullable(i).map(myEntity -> myEntity.getName()).orElse("null")).collect(Collectors.toList()));




        //判断对象是否为空
        MyEntity myEntity = null;
        System.out.println(Optional.ofNullable(myEntity).map(i -> i.getName()).isPresent());

        //判断对象不为空执行方法
        myEntity = new MyEntity(3, "4");
        Optional.ofNullable(myEntity).map(i -> i.getName()).ifPresent(i -> System.out.println(i));


        //如果对象为空则给个值
        myEntity = null;
        System.out.println(Optional.ofNullable(myEntity).map(i -> i.getName()).orElse("null"));

    }
}
