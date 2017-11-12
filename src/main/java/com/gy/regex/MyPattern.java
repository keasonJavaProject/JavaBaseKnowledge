package com.gy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/2.
 */
public class MyPattern {
    /**
         Capturing groups are numbered by counting their opening parentheses from left to right.
         In the expression ((A)(B(C))), for example, there are four such groups:
         0      ((A)(B(C)))
         1    	((A)(B(C)))
         2    	(A)
         3    	(B(C))
         4    	(C)
         Group zero always stands for the entire expression.
     */
    public static void main(String[] args) {
        String testStr = "aabbccdd";
        Pattern pattern = Pattern.compile("(aa)(bb)(cc)(dd)");
        Matcher matcher = pattern.matcher(testStr);
        if (matcher.find()) {
            for (int i = 0; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
