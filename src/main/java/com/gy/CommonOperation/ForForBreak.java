package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/5/24.
 * 多层for嵌套，break只对当前循环有效，不对外层循环产生影响。
 */
public class ForForBreak {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.println("i:"+i+" j:"+j);
                if (j == 3) {
                    break;
                }
            }
        }
    }
}
