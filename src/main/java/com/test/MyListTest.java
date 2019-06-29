package com.test;

import com.google.common.collect.*;

import java.util.*;

public class MyListTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        //把数组分成指定大小份
        System.out.println("把数组分成指定大小份");
        List<List<Integer>> lists = Lists.partition(list, 4);
        lists.forEach(listTemp-> System.out.println(listTemp));

        //数组笛卡尔积
        System.out.println("数组笛卡尔积");
        List listOne = Lists.newArrayList(1, 2, 3);
        List listTwo = Lists.newArrayList( 4, 5,6);
        List listThree = Lists.newArrayList( 7, 8,9);
        List<List> listProduct = Lists.cartesianProduct(listOne, listTwo,listThree);
        listProduct.forEach(listtemp -> System.out.println(listtemp));


        System.out.println("\r\n \r\n SET Method ");
        HashSet setA = Sets.newHashSet(1, 2, 3, 4, 5);
        System.out.println("setA");
        System.out.println(setA);

        HashSet setB = Sets.newHashSet(4, 5, 6, 7, 8);
        System.out.println("setB");
        System.out.println(setB);
        Set union = Sets.union(setA, setB);
        System.out.println("union");
        System.out.println(union);

        Set intersection = Sets.intersection(setA, setB);
        System.out.println("intersection");
        System.out.println(intersection);

        //setA - setB
        Set difference = Sets.difference(setA, setB);
        System.out.println("difference");
        System.out.println(difference);

        //Map 过滤key 和 value
        System.out.println("\r\n \r\n Map Method");
        Map<String, Map<String, String>> map = new HashMap<>();
        Map map1 = new HashMap();
        map1.put("11", "11");
        map.put("1", map1);


        map1 = new HashMap();
        map1.put("22", "22");
        map.put("2", map1);

        map1 = new HashMap();
        map1.put("33", "33");
        map.put("3", map1);

        System.out.println("all maps " + map);

        System.out.println("filterKeys:");
        Map mapFilterKeys = Maps.filterKeys(map, key -> key.equals("3"));
        System.out.println(mapFilterKeys);

        System.out.println("filterValues:");
        Map mapFilterValues = Maps.filterValues(map, value -> ((Map)value).containsKey("22"));
        System.out.println(mapFilterValues);

        Map<Integer,Integer> mapOne = ImmutableMap.of(1, 1, 2, 2, 3, 3,4,4);
        Map<Integer, Integer> mapTwo = ImmutableMap.of(3, 33, 4, 4, 5, 5);
        MapDifference mapDifference = Maps.difference(mapOne, mapTwo);
        System.out.println("\r\n entriesOnlyOnLeft");//key 只在左边
        System.out.println(mapDifference.entriesOnlyOnLeft());

        System.out.println("\n entriesOnlyOnRight");//key 只在右边
        System.out.println(mapDifference.entriesOnlyOnRight());

        System.out.println("\n entriesInCommon");//key和value  在2个Map都一样的
        System.out.println(mapDifference.entriesInCommon());

        System.out.println("\n entriesDiffering");//key相同，value 不同
        System.out.println(mapDifference.entriesDiffering());


        //list removeIf
        list.removeIf(info -> info.intValue() == 1);

    }
}
