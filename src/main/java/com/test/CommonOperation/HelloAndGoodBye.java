package com.test.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/10.
 */
public class HelloAndGoodBye {
    public static void main(String[] args) {
        try {
            System.out.println(1);
        } catch (Exception e) {
            System.out.println(2);
        }finally {
            System.out.println(3);
        }

        try {
            System.out.println(4);
            System.exit(0);//exist 之后finally就不会走了,但是return 之后 finally还是会走
        } catch (Exception e) {
            System.out.println(5);
        }finally {
            System.out.println(6);
        }
    }
}
