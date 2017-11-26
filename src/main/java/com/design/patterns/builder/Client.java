package com.design.patterns.builder;

/**
 * Created by keason on 2017/11/26.
 */
public class Client {
    public static void main(String[] args) {
        Builder builder = new BuilderOne();
        builder.init();
        builder.buildPart1();
        builder.buildPart2();
        System.out.println(builder.retrieveProduct().toString());
    }
}
