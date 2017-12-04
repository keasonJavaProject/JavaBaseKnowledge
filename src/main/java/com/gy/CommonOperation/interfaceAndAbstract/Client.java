package com.gy.CommonOperation.interfaceAndAbstract;

public class Client {
    public static void main(String[] args) {
//        报错，不能给final 的temp 赋值
//        InterfaceClass.temp="B";
        System.out.println(InterfaceClass.temp);

        //接口和抽象类，都可以new 一个实现类，不过要实现方法。
        InterfaceClass interfaceClass = new InterfaceClass() {
            @Override
            public String getStringTwo() {
                return "";
            }
        };


        //这里接口继承，则需要同时实现三个方法。
        InterfaceClassThree three= new InterfaceClassThree() {
            @Override
            public String getStringThree() {
                return null;
            }

            @Override
            public String getStringTwo() {
                return null;
            }

            @Override
            public String getString() {
                return null;
            }
        };


    }
}
