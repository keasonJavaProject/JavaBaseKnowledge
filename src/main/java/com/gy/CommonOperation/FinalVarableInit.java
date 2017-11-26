package com.gy.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/10.
 */
public class FinalVarableInit {
    static final long longValue = getValue();
    static final long temp =2 ;

    long longValueOne = getValueOne();
    long tempOne =12 ;



    public static Long getValue() {
        return temp;
    }
    public Long getValueOne() {
        return tempOne;
    }

    public static void main(String[] args) {
        System.out.println(longValue);

        //变量通过函数初始化之后，值如果没有改变过，下次取变量的值的时候，不会通过函数再次计算，相当于固定的。
        FinalVarableInit finalVarableInit = new FinalVarableInit();

        System.out.println(finalVarableInit.longValueOne);//0
        System.out.println(finalVarableInit.tempOne);//2
        System.out.println(finalVarableInit.longValueOne);//0
        System.out.println(finalVarableInit.getValueOne());//调用函数重新计算

//        通过函数计算出来的final变量，不能再次重新赋值。
//        longValue =2;

    }
}
