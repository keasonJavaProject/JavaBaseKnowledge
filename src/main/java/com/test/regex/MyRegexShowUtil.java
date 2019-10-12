package com.test.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/2.
 */
public class MyRegexShowUtil {
    public static void showRegexGroupData(Pattern regex, String orgStr) {
        Pattern pattern = regex;
        Matcher matcher = pattern.matcher(orgStr);
        while (matcher.matches()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }

    public static void showRegexPosition(Pattern regex, String orgStr) {
        Pattern pattern = regex;
        Matcher matcher = pattern.matcher(orgStr);
        boolean looped =false;
        while (matcher.find()){
            System.out.println(String.format("%d-%d", matcher.start(), matcher.end()));
            looped = true;
        }
        if (!looped) {
            System.out.println("空");
        }
    }
}
