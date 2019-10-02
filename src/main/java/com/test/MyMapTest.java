package com.test;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public class MyMapTest {
    public static void main(String[] args) {

        //Map 过滤key 和 value
        System.out.println("Map Method");
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
        System.out.println("\n\nmapOneLeft  " + JSON.toJSONString(mapOne));

        Map<Integer, Integer> mapTwo = ImmutableMap.of(3, 33, 4, 4, 5, 5);
        System.out.println("mapTwoRight  " + JSON.toJSONString(mapTwo));

        MapDifference mapDifference = Maps.difference(mapOne, mapTwo);
        System.out.println("\r\n entriesOnlyOnLeft --key 只在左边");//key 只在左边
        System.out.println(mapDifference.entriesOnlyOnLeft());

        System.out.println("\n entriesOnlyOnRight -- key 只在右边");//key 只在右边
        System.out.println(mapDifference.entriesOnlyOnRight());

        System.out.println("\n entriesInCommon -- key和value  在2个Map都一样的");//key和value  在2个Map都一样的
        System.out.println(mapDifference.entriesInCommon());

        System.out.println("\n entriesDiffering key相同，value 不同");//key相同，value 不同
        System.out.println(mapDifference.entriesDiffering());



        System.out.println("\n\n\n\n Immutable 不能改变的,因此不能做增删改");
        Map mapImmu = null;
        try {
            System.out.println("ImmutableMap.of(1, 2) remove()报异常");
            mapImmu = ImmutableMap.of("199", 199);
            mapImmu.remove(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println("ImmutableMap.of(1, 2) put()报异常");
            Map mapImmu2 = ImmutableMap.of(1, 2);
            mapImmu2.put(2,1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.putAll(mapImmu);
        System.out.println("map putAll mapImmu" + map);

    }
}
