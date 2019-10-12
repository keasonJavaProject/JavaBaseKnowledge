package com.test.lamda;

import java.util.function.Function;

/**
 * Created by PicaHelth on 2017/9/14.
 */
public class MyLamdaFunction {
    public static void main(String[] args) {
        Function<String,String> function = new Function<String, String>() {
            @Override
            public String apply(String s) {
                return s.toUpperCase();
            }
        };


        System.out.println(function.apply("aaaa"));
    }
}
