package com.design.patterns.singleton;

public class SingletonOne {
    private static SingletonOne sin  =new SingletonOne();

    private SingletonOne() {

    }
    public static SingletonOne getSin() {
        return sin;
    }
}
