package com.test;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

public class MySetTest {
    public static void main(String[] args) {
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
    }
}
