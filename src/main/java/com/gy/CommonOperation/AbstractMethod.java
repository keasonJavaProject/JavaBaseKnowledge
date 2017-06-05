package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/6/5.
 */
public abstract class AbstractMethod {
    String temp ="A";
    AbstractMethod(){
        System.out.println("father construct"+temp);
    };
    void show(){
        System.out.println("A show()");
    }
    abstract void showM1();
    //报错，abstract method can not have body
//    abstract void showM(){};
}
