package com.test.regex;

import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/2.
 * {@link
 *          "https://docs.oracle.com/javase/8/docs/api/"
 *          "https://zhuanlan.zhihu.com/p/84279687"
 *}
 */
public class MyRegexThreeModel {
    public static void main(String[] args) {

        /**
         * 贪婪模式（Greedy）
         * 在数量匹配中，如果单独使用+、？、*、{min,max}等量词，正则表达式会匹配尽可能多的内容
         * text="abbc" , regex="ab{1,3}c"，发生了一次匹配失败，就会引起一次回溯
         * text="abbbc" , regex="ab{1,3}c"，匹配成功
         *
         *
         * 懒惰模式（Reluctant）
         * 在懒惰模式下，正则表达式会[尽可能少地重复匹配字符]，如果匹配成功，会继续匹配剩余的字符串
         * 使用 ?  开启懒惰模式，text="abc" , regex="ab{1,3}?c"
         * 匹配结果是"abc"，在该模式下NFA自动机首先选择最小的匹配范围，即匹配1个b字符，避免了回溯问题
         *
         *
         * 独占模式（Possessive）
         * 和贪婪模式一样，独占模式一样[会最大限度地匹配更多内容]，但在匹配失败时会结束匹配，不会发生回溯问题
         * 使用 +  开启懒惰模式，text="abbc" , regex="ab{1,3}+bc"
         * 结果是不匹配，结束匹配，不会发生回溯问题
         */









        String test = "a<tr>aava </tr>abb ";
        System.out.println("\n\n原始字段 " + test);
        /** 贪婪型（最大匹配）
         * ①“<”匹配字符串的“<”。
         * ②“.+”匹配字符串的“tr>aava</tr>ab”，在进行最大匹配时，它把两个“>”都匹配了，它匹配了所有字符，直到文本的最后字符“b”
         * ③这时，发现不能成功匹配“>”，开始按原路回退，用“a”与“>”匹配，直到“ab”前面的“>”匹配成功。
         * Greedy quantifiers
         * X?	X, once or not at all
         * X*	X, zero or more times
         * X+	X, one or more times
         * X{n}	X, exactly n times
         * X{n,}	X, at least n times
         * X{n,m}	X, at least n but not more than m times
         */
//        System.out.println(test.replaceAll("<.+>", "###"));     //a###abb
        System.out.println("\n\na<tr>aava </tr>abb 贪婪模式 ");
        Pattern pattern = Pattern.compile("a<.+>");
        MyRegexShowUtil.showRegexPosition(pattern, test);
        System.out.println("==");
        pattern = Pattern.compile("<.+>");
        MyRegexShowUtil.showRegexPosition(pattern, test);



        //懒惰型（最小匹配）
        /**
         * Reluctant quantifiers
         * X??	X, once or not at all
         * X*?	X, zero or more times
         * X+?	X, one or more times
         * X{n}?	X, exactly n times
         * X{n,}?	X, at least n times
         * X{n,m}?	X, at least n but not more than m times
         */
//        System.out.println(test.replaceAll("<.+?>", "###"));    //a###aava ###abb
        System.out.println("\n\na<tr>aava </tr>abb 懒惰模式");
        pattern = Pattern.compile("<.+?>");
        MyRegexShowUtil.showRegexPosition(pattern, test);
        System.out.println("==");
        pattern = Pattern.compile("a<.+?>");
        MyRegexShowUtil.showRegexPosition(pattern, test);



        //独占型(完全匹配)
        /**
         * Possessive quantifiers
         * X?+	X, once or not at all
         * X*+	X, zero or more times
         * X++	X, one or more times
         * X{n}+	X, exactly n times
         * X{n,}+	X, at least n times
         * X{n,m}+	X, at least n but not more than m times
         */
        System.out.println("\n\na<tr>aava </tr>abb 独占模式");
        pattern = Pattern.compile("a<.++>");//可以一直匹配到"a<tr>aava </tr>abb" ,最后就没有">" 所以匹配不上
        MyRegexShowUtil.showRegexPosition(pattern, test);
        System.out.println("==");

        pattern = Pattern.compile("a<.++");//可以一直匹配到"a<tr>aava </tr>abb"
        MyRegexShowUtil.showRegexPosition(pattern, test);

        System.out.println("==");
        pattern = Pattern.compile("a<.{2}+>");//可以完全匹配"a<tr>"
        MyRegexShowUtil.showRegexPosition(pattern, test);

        System.out.println("==");
        pattern = Pattern.compile("a<.{3}+>");;//可以完全匹配"a<tr" 但是在".{3}"的第三个位置匹配错误
        MyRegexShowUtil.showRegexPosition(pattern, test);
    }
}
