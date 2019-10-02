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

        try {
            list.remove(1);
            System.out.println("Arrays.asList list.remove(1)"+list);
        } catch (Exception e) {
            System.out.println("Arrays.asList list.remove(1) UnsupportedOperationException"+list);
        }

        try {
            list.add(1, 11);
            System.out.println("Arrays.asList list.add " + list);
        } catch (Exception e) {
            System.out.println("Arrays.asList list.add UnsupportedOperationException " + list);
        }


        try {
            List<Integer> list2 = Arrays.asList(1, 2);
            list.retainAll(list2);
            System.out.println("Arrays.asList list.retainAll(list2) " + list);
        } catch (Exception e) {
            System.out.println("Arrays.asList list.retainAll(list2) UnsupportedOperationException " + list);
        }





        list = Lists.newArrayList(1, 2, 3, 4);
        try {
            list.remove(1);
            System.out.println("\n\n\nLists.newArrayList list.remove(1)"+list);
        } catch (Exception e) {
            System.out.println("\n\n\nLists.newArrayList list.remove(1) UnsupportedOperationException"+list);
        }

        try {
            list.add(1, 11);
            System.out.println(" Lists.newArrayList list.add " + list);
        } catch (Exception e) {
            System.out.println(" Lists.newArrayList list.add UnsupportedOperationException " + list);
        }


        try {
            List<Integer> list2 =  Lists.newArrayList(1, 2);
            list.retainAll(list2);
            System.out.println(" Lists.newArrayList list.retainAll(list2) " + list);
        } catch (Exception e) {
            System.out.println(" Lists.newArrayList list.retainAll(list2) UnsupportedOperationException " + list);
        }



        //数组笛卡尔积
        System.out.println("数组笛卡尔积");
        List listOne = Lists.newArrayList(1, 2, 3);
        List listTwo = Lists.newArrayList( 4, 5,6);
        List listThree = Lists.newArrayList( 7, 8,9);
        List<List> listProduct = Lists.cartesianProduct(listOne, listTwo,listThree);
        listProduct.forEach(listtemp -> System.out.println(listtemp));

        //list removeIf
        list.removeIf(info -> info.intValue() == 1);

    }
}
