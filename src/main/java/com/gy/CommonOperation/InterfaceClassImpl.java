package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/6/5.
 */
public class InterfaceClassImpl implements InterfaceClass{
    public static void main(String[] args) {
//        报错，不能给final 的temp 赋值
//        InterfaceClass.temp="B";
        System.out.println(InterfaceClass.temp);
    }
}
