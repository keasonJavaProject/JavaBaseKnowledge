package com.gy.regex;

import java.util.Arrays;

/**
 * Created by PicaHelth on 2017/9/2.
 * 1、replaceAll中的是最小匹配，会查找所有字符串, 不像Pattern.compile(""),会默认起始位置
 */
public class MyReplaceAll {
    public static void main(String[] args) {
        String replaceStr = "aabbaaccaaffaa";
        System.out.println(replaceStr.replaceAll("aa","**"));//替换全部

        System.out.println(replaceStr.replaceAll("^(aa)","**"));//替换开头

        System.out.println(replaceStr.replaceAll("(aa)$","**"));//替换结尾

        //替换掉从开头起，第三个aa 为**
        System.out.println(replaceStr.replaceAll("(aa)(.*)(\\1)(.*)(\\1)(.*)(\\1)","$1$2$3$4**$6$7"));

        //test3
        String aa ="AAABBBCCCCCC";
        aa = aa.replaceAll("(.)\\1+", "$1");
        System.out.println("test3:"+aa);

        //批量替换相同字符,补全成相同前缀，然后再截取出相同的长度。
        String temp = "192.168.1.200 10.10.10.10 3.3.50.3 127.0.0.1";
        temp=temp.replaceAll("(\\d+)", "00$1");//00192.00168.001.00200 0010.0010.0010.0010 003.003.0050.003 00127.000.000.001
        temp=temp.replaceAll("0+(\\d{3})", "$1");//将ip地址补成同样位数  192.168.001.200 010.010.010.010 003.003.050.003 127.000.000.001
        String[] str1=temp.split(" +");
        Arrays.sort(str1);
        for(String ips:str1){
            System.out.println(ips.replaceAll("0+(\\d+)", "$1"));
        }

    }

}
