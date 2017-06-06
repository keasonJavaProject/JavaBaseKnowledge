package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/6/5.
 */
public abstract class AbstractMethod {
    String temp ="A";
    private  String tempa ="AA";
    AbstractMethod(){
        System.out.println("father construct"+temp);
        //报错，abstract method can not have body
//    abstract void showM(){};
    };
    void show(){
        System.out.println("A show()");
    }
    abstract void showM1();

    public String getTempa() {
        return tempa;
    }
}
