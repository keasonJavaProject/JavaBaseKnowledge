package com.gy.CommonOperation;

import java.util.Arrays;

/**
 * Created by PicaHelth on 2017/8/15.
 */
public class HidePropertyMain {
    public static void main(String[] args) {
        //会报错误，说id是私有的，所以HidePropertyTwo 隐藏了 HidePropertyOne
        //所以除了Override之外，要避免名字重用。
//        System.out.println(new HidePropertyTwo().id);
        System.out.println(((HidePropertyOne)new HidePropertyTwo()).id);
        System.out.println(Arrays.toString(args));
    }
}
