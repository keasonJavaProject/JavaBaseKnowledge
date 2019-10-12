package com.test.CommonOperation;

/**
 * Created by KEASON on 2017/5/24.
 * 在TIJ中，说了，只有for()支持逗号运算符。同事计算多列
 */
public class CommonOperation {
    public static void main(String[] args) {
        for(int i=0,j=0;i<10 && j<10;i++,j+=2){
            System.out.println("i:"+i+"     j:"+j);
        }
    }
}
