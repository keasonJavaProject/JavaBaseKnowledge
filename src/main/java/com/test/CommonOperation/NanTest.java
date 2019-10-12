package com.test.CommonOperation;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

/**
 * Created by PicaHelth on 2017/8/9.
 */
public class NanTest {
    public static void main(String[] args) {
        double i = Double.NaN;//Float.NaN;
        if (i != i) {
            System.out.println("i!=i");
        }

        String a = "1";
        if (a !=a+0) {
            System.out.println("a != a+0");
        }

        Integer aa = new Integer(1);
        Integer bb =new Integer(1);
        if (aa >= bb && aa <= bb && aa != bb) {
            System.out.println("aa >= bb && aa <= bb && aa != bb");
        }

        if (Integer.MIN_VALUE != 0 && Integer.MIN_VALUE == -Integer.MIN_VALUE) {//Long.MIN_VALUE ,Short.MIN_VALUE , Byte.MMIN_MIN_VALUE
            System.out.println("haha");
        }

        double largeNum = 300000000000000000d;//double float
        System.out.println(largeNum);


        //2000000000f==2000000050f
        System.out.println(Math.ulp(2000000000f)/2);//输出64 ，也就是这个数进制是64，64之内都不能区分
        System.out.println(2000000000f==2000000064f);//true
        System.out.println(2000000000f==2000000065f);//false





    }
}
