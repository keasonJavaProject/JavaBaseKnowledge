package com.gy.regex;

/**
 * Created by PicaHelth on 2017/9/2.
 */
public class MyRegexThreeModel {
    public static void main(String[] args) {

        String test = "a<tr>aava </tr>abb ";

        /** 贪婪型（最大匹配）
         * ①“<”匹配字符串的“<”。
         * ②“.+”匹配字符串的“tr>aava</tr>ab”，在进行最大匹配时，它把两个“>”都匹配了，它匹配了所有字符，直到文本的最后字符“b”
         * ③这时，发现不能成功匹配“>”，开始按原路回退，用“a”与“>”匹配，直到“ab”前面的“>”匹配成功。
         */
        System.out.println(test.replaceAll("<.+>", "###"));     //a###abb


        //勉强型（最小匹配）
        System.out.println(test.replaceAll("<.+?>", "###"));    //a###aava ###abb



        System.out.println();
        System.out.println();
        //占有型(完全匹配)
        //特别注意， * 和 ? replaceAll 会被执行2次， 0 一次，非0 一次。   + 只会被replaceAll一次
        test = "a<tr>aava </tr>abb a<tr>aava </tr>abb ";
        System.out.println(test.replaceAll("(a<tr>aava </tr>abb )+", "###"));    //###          2            one or more times
        System.out.println(test.replaceAll("(a<tr>aava </tr>abb )?", "###"));    //#########    0,1,1        once or not at all
        System.out.println(test.replaceAll("(a<tr>aava </tr>abb )*", "###"));    //######       0,           zero or more times

    }
}
