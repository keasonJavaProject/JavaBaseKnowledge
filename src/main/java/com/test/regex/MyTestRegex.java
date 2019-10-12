package com.test.regex;

import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/1.
 * 正则分组，测试知道 compile() ：
 * 1    "匹配字符串.*" = "^匹配字符串.*"           默认开头
 * 2    ".*匹配字符串" = ".*匹配字符串$"           默认结尾
 * 3    "." 表示匹配任意一个字符， 而"\\." 才表示匹配‘英文句号’
 * 4    compile()中的特殊字符，会显示成特殊颜色
 *
 */
public class MyTestRegex {

    public static void main(String[] args) {
        //Pattern 匹配模式的几个选项/////////////////////////////////////////////////////////////////////////////
        /**
         * Pattern compile(String regex, int flags)
         * Pattern.CANON_EQ 当且仅当两个字符的”正规分解(canonical decomposition)”都完全相同的情况下，才认定匹。
         *                  比如用了这个标志之后，表达式”a\u030A”会匹配”?”.默认情况下，不考虑”规范相等性(canonical equivalence)”
         * Pattern.CASE_INSENSITIVE(?i) 默认情况下,大小写不明感的匹配只适用于US-ASCII字符集。
         * Pattern.UNICODE_CASE(?u) 对Unicode字符进行大小不明感的匹
         * Pattern.COMMENTS(?x)  在这种模式下,匹配时会忽略(正则表达式里的)空格字符(译者注:不是指表达式里的”\s”，而是指
         *                   表达式里的空格,tab,回车之类)。注释从#开始,一直到这行结束。可以通过嵌入式的标志来启用Unix行模式.
         * Pattern.DOTALLL(?s) 在这种模式下，表达式’.’可以匹配任意字符，包括表示一行的结束符。默认情况下，表达式’.’不匹配行的结束符。
         * Pattern.MULTILINE(?m)    在这种模式下,’\^’和’$’分别匹配一行的开始和结束。此外,’^’仍然匹配字符串的开始,’$’也匹配字符串的结束。默认情况下,这两个表达式仅仅匹配字符串的开始和结束。
         * Pattern.UNIX_LINES(?d)   在这个模式下,只有’\n’才被认作一行的中止,并且与’.’,’^’,以及’$’进行匹配。
         */
        System.out.println("Pattern.CANON_EQ \\u0041 和 A 是一样的");
        Pattern pattern = Pattern.compile("\u0041", Pattern.CANON_EQ);
        MyRegexShowUtil.showRegexPosition(pattern, "Abc");


        System.out.println("\n\nPattern.CASE_INSENSITIVE a 和A 都匹配 写法1");
        pattern = Pattern.compile("(?i)a");
        MyRegexShowUtil.showRegexPosition(pattern, "Abc");
        MyRegexShowUtil.showRegexPosition(pattern, "abc");
        System.out.println("Pattern.CASE_INSENSITIVE a 和A 都匹配 写法2");
        pattern = Pattern.compile("a",Pattern.CASE_INSENSITIVE);
        MyRegexShowUtil.showRegexPosition(pattern, "Abc");
        MyRegexShowUtil.showRegexPosition(pattern, "abc");



        System.out.println("\n\nPattern.COMMENTS 忽略正则表达式里的里边的空格字符（tab）");
        pattern = Pattern.compile("a+     ",Pattern.COMMENTS);
        MyRegexShowUtil.showRegexPosition(pattern, "abc");



        System.out.println("\n\nPattern.DOTALLL ’.’可以匹配结束符");
        pattern = Pattern.compile("([abc].*)");
        MyRegexShowUtil.showRegexPosition(pattern, "abc");
        pattern = Pattern.compile("([abc].*)");
        MyRegexShowUtil.showRegexPosition(pattern, "abc\n");
        System.out.println("添加Pattern.DOTALLL的情况");
        pattern = Pattern.compile("([abc].*)",Pattern.DOTALL);
        MyRegexShowUtil.showRegexPosition(pattern, "a\nb\nc\n");



        System.out.println("\n\nPattern.MULTILINE 匹配多行");
        String regex = "^[a-z]{3}$";
        String input = "abc\r\ndef";
        pattern = Pattern.compile(regex);
        MyRegexShowUtil.showRegexPosition(pattern, input);
        pattern = Pattern.compile(regex,Pattern.MULTILINE);
        MyRegexShowUtil.showRegexPosition(pattern, input);


        System.out.println("\n\nPattern.UNIX_LINES 匹配多行");
        regex = "[a-z]{3}";
        input = "aAc\rabc\neRt";
        pattern = Pattern.compile(regex,Pattern.UNIX_LINES | Pattern.CASE_INSENSITIVE);
        MyRegexShowUtil.showRegexPosition(pattern, input);

    }
}
