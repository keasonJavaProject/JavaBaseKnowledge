package com.gy.CommonOperation;

import java.util.Arrays;

/**
 * Created by KEASON on 2017/5/24.
 */
public class ArrayThreeTest {
    public static void main(String[] args) {
        int m [][][]  =
        {
                {
                        {1,2,3},
                        {4,5,6}
                },
                {
                        {7,8,9},
                        {10,11,12}
                },
                {
                        {13,14,15},
                        {16,17,18}
                }
        };
        for (int i = 0; i < m.length; i++) {
            for(int j=0;j<m[i].length;j++){
                for(int x=0;x<m[i][j].length;x++){
                    System.out.println(m[i][j][x]);
                }
            }
        }
    }
}
