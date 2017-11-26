package com.design.patterns.singleton;

public class SingletonThree {
    private static SingletonThree sin ;

    private SingletonThree() {

    }

    public static SingletonThree getSin() {
        if (sin == null) {
            //锁住new 对象的语句
            //synchronized(this) 只锁定对象，如果对象不一样，仍然可以并发。
            synchronized (SingletonThree.class) {
                if (sin == null) {
                    sin = new SingletonThree();
                }
            }
        }
        return sin;
    }
}
