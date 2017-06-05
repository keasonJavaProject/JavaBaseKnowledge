package com.gy.CommonOperation;

import com.gy.BaseInfo;

/**
 * Created by KEASON on 2017/5/27.
 */
public class FinalTest {
    static Byte b;
    static Byte getB(){return new FinalTest().b;};
    public static void main(String[] args) {
        final BaseInfo baseInfo=new BaseInfo(1001L,"name1001");

        //这样会报错的，引用对象不能直接修改引用，但能修改对象中的属性。
//        baseInfo=new BaseInfo(1001L,"name1001");
        baseInfo.setName("name2002");
        System.out.println(baseInfo);


        System.out.println(getB());

        final String str ="111";
        String str2 =str;
        str2="2333";

        String one ="1";
        System.out.println(one);
        String two = one;
        two ="3";
        System.out.println(one);

        String one1 ="11";
        String two1 = one1;
        System.out.println(two1);
        one1 ="32";
        System.out.println(two1);

        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        System.out.println(a==(b+2));
        System.out.println(a==(c+2));


    }
}
