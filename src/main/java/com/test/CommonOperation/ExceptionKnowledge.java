package com.test.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/9.
 */
public class ExceptionKnowledge {
    interface a {
        void f() throws ClassNotFoundException;
    }

    interface b {
        void f() throws IndexOutOfBoundsException;
    }

    interface c extends a, b {
    }

    class abc implements c {
        public void f() {//这里f不用抛出或者捕获 ClassNotFoundException，IndexOutOfBoundsException ，因为异常要求交集
            System.out.println("hello");
        }
    }


    //注意这个方法，没有返回值，直接throw exception的
    private Long getLongValue() throws Exception{
        throw new Exception();
    }
}
