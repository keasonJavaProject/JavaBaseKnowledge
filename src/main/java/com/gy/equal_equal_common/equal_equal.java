package com.gy.equal_equal_common;

/**
 * Created by PicaHelth on 2017/9/5.
 */
public class equal_equal {
    public static void main(String[] args) {
        /**
         * java中还有与Integer类似的是Long，它也有一个缓存，在区间[-128,127]范围内获取缓存的值，
         * 而Long与long比较的时候先转换成long类型再做值的比较
         * 注意：== 运算符在不遇到算数运算符的情况下不会自动拆箱
         *      equals(),方法不处理数据转化关系。
         */
        Integer a =1;
        Integer b=2;
        Integer c=3;
        Integer d= 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;

        System.out.println(c == d);// true
        System.out.println(e == f);// false
        System.out.println(c == (a+b));//true
        System.out.println(c.equals((a+b)));//true
        System.out.println(g.equals(a + b));//false
        System.out.println(g == (a + b));//true
    }
}
