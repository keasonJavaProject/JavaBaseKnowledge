package com.gy.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/2.
 */
public class MyRegexShowUtil {
    public static void showRegexData(Pattern regex, String orgStr) {
        Pattern pattern = regex;
        Matcher matcher = pattern.matcher(orgStr);
        if(matcher.matches()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
