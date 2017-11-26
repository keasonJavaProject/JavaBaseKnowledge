package com.gy.regex;

import java.util.regex.Matcher;
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
        String line ="'<i ng-if=\"grid.appScope.functionRoleArr[5] == 1\" ng-click=\"grid.appScope.periodChanage(row.entity)\"  class=\"glyphicon glyphicon-ok list_icon\"></i>'";
//        line ="fffgrid.appScope.functionRoleArr[5] == 1";
        Pattern pattern = Pattern.compile("(.*\"grid.appScope.)(.*)(\"[ ]*ng.*)");
        Matcher m = pattern.matcher(line);
        if(m.matches()) {
            for (int i =0;i<=m.groupCount();i++){
                System.out.println(m.group(i));
            }
        }

        //3     "." 表示匹配任意一个字符， 而"\\." 才表示匹配‘英文句号’
        pattern = Pattern.compile("(.)",Pattern.DOTALL);
        m = pattern.matcher("n");
        if(m.matches()) {
            for (int i =0;i<m.groupCount();i++){
                System.out.println(m.group(i));
            }
        }

        pattern = Pattern.compile("(\\.)",Pattern.DOTALL);
        m = pattern.matcher(".");
        if(m.matches()) {
            for (int i =0;i<m.groupCount();i++){
                System.out.println(m.group(i));
            }
        }
    }
}
