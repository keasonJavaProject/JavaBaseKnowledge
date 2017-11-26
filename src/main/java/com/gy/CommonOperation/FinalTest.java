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


        //通过调试断点，查看内存地址，得知：
        /*
            通过给String a ="xxx";,这样如果等号右侧值是一样的，则不管有多少个变量，他们的内存地址都是一样的。
            通过String b = a+"xxx";每次计算都会新生成一个对象，不管等号右侧 a+"xxx"  的到的结果是否一样。
            而通过 final String b = a +"xxx"; 每次生成的对象值如果相同，则他们指向同一片内存区域。
         */
        String a = "hello2";
        final String b = "hello";
        String c = "hello";

        System.out.println(a==(b+2));
        System.out.println(a==(c+2));

        String b1 = b+2;
        String b2 = b+2;
        String c1= c+2;
        String c2= c+2;
        System.out.println(a==b1);
        System.out.println(a==b2);
        System.out.println(a==c1);
        System.out.println(a==c2);


    }
}
