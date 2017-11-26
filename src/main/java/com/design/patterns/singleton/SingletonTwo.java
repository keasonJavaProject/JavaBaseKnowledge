package com.design.patterns.singleton;

public class SingletonTwo {
    private static SingletonTwo sin ;

    private SingletonTwo() {

    }

    //对获取实例的方法进行同步
    public static synchronized SingletonTwo getSin() {
        if (sin == null) {
            sin = new SingletonTwo();
        }
        return sin;
    }
}
