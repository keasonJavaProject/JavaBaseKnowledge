package com.test.CommonOperation.interfaceAndAbstract;

/**
 * Created by KEASON on 2017/6/5.
 * interface  不能implements,只能多重继承
 */
public interface InterfaceClassThree extends InterfaceClass,InterfaceClassTwo{
//    报错 修饰符，private 不能在此使用
//    private String temp2 ="A";

//    报错，protect 修饰符，不能在此处使用
//    protected String temp1 ="A";

//    接口中定义的变量，默认是 public static final 的
     String temp ="A";

     String getStringThree();
}
