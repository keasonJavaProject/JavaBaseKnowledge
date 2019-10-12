package com.test.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/10.
 */
public class WorkOut {
    public static void main(String[] args) {
        workout();
        System.out.println("it's nap time");
    }


    private static void workout() {//类似于无限循环
        try {
            System.out.println("before workout");
            workout();
        } finally {
            System.out.println("before finally workout");
            workout();
        }
    }
}
