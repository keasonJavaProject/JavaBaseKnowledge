package com.gy.regex;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by keason on 2017/8/29.
 */
public class testReg {
    private static  Pattern pattern = Pattern.compile(".*field[ ]*:[ ]*'(.*)'.*");
    private static  Pattern patternD = Pattern.compile(".*displayName[ ]*:[ ]*'(.*)'.*");
    private static  Pattern patternB1 = Pattern.compile("(.*grid.appScope.)(.*)(\"[ ]+ng.*)");
    private static  Pattern patternB2 = Pattern.compile("(.*ng-click=\"grid.appScope.)(.*)(\\(.*)");



    public static void main(String[] args) throws IOException {
        InputStream inputStream  = new  FileInputStream("D:\\JavaProject\\MyGitHueProject\\JavaBaseKnowledge\\src\\main\\java\\my\\regex\\pica_constants_icon.js");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String headerStr  ="<table class=\"table table-hover table-bordered\" >\n" +
                "<thead style=\"background-color: #f9f9f9;\">\n" +
                "<tr>\n";
        String bodyStr ="<tbody>\n" +
                "<tr ng-repeat=\"dataItem in dataItems\">\n";
        String operationStr = "\t<td style=\"text-align: right\">\n" +
                "\t\t<span ng-if=\"functionRoleArr[5] == 1\"><a href=\"#\" ng-click=\"reviewCourse(dataItem)\">提交</a></span>\n" +
                "\t\t<span ng-if=\"functionRoleArr[0] == 1\"><span class=\"text-explode\">|</span><a href=\"#\" ng-click=\"teacherManage(dataItem)\">查看</a></span>\n" +
                "\t\t<span ng-if=\"functionRoleArr[1] == 1\"><span class=\"text-explode\">|</span><a href=\"#\" ng-click=\"updateCourse(dataItem)\">修改</a></span>\n" +
                "\t\t<span ng-if=\"functionRoleArr[2] == 1\"><span class=\"text-explode\">|</span><a href=\"#\" ng-click=\"updateCourse(dataItem)\">删除</a></span>\n" +
                "\t </td>\n";

        String tail ="<div class=\"col-sm-12\" style=\"padding: 0px;\">\n" +
                "\t<pre  class=\"paginationDes\" style=\"float:right\">总记录数: <span ng-bind=\"totalItems\"></span>, 页码: <span ng-bind=\"pageNo\"></span> / <span ng-bind=\"totalPages\"></span></pre>\n" +
                "\t<div  style=\" float: right;margin-top: -20px;\">\n" +
                "\t\t<uib-pagination ng-change=\"pageChanged()\" ng-model=\"pageNo\"\n" +
                "\t\t\t\t\t\tnum-pages=\"totalPages\" items-per-page=\"pageSize\" total-items=\"totalItems\"  first-text=\"页首\" last-text=\"页尾\"\n" +
                "\t\t\t\t\t\tprevious-text=\"&lsaquo;\" next-text=\"&rsaquo;\"\n" +
                "\t\t\t\t\t\tmax-size=\"btnSize\" class=\"pagination-sm\" boundary-links=\"true\" rotate=\"false\" >\n" +
                "\t\t</uib-pagination>\n" +
                "\t\t<div class=\"page-div\">\n" +
                "\t\t\t<select class=\"form-control\" style=\"height: 29px;\" ng-model=\"pageSize\" ng-change=\"setPage()\" ng-options=\"item for item in pageSizeList\">\n" +
                "\t\t\t</select>\n" +
                "\t\t</div>\n" +
                "\t</div>\n" +
                "</div>";

        String line ="";
        while ((line = bufferedReader.readLine())!=null) {
            if (line.contains("appScope")) {
                Matcher matcher = patternB1.matcher(line);
                if (matcher.matches()) {
                    System.out.println(matcher.group(2));
                }

                matcher = patternB2.matcher(line);
                if (matcher.matches()) {
                    System.out.println(matcher.group(2));
                }

            }

            if (line.contains("id")) {
                continue;
            }
            if (line.contains("field")) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    bodyStr = bodyStr+
                            "\t<td>\n" +
                            "\t\t<div class=\"scissor\">\n" +
                            "\t\t\t<div class=\"sciss\">\n" +
                            "\t\t\t\t <span title=\"{{dataItem."+matcher.group(1)+"}}\" ng-bind=\"dataItem."+matcher.group(1)+"\"></span>\n" +
                            "\t\t\t</div>\n" +
                            "\t\t</div>\n" +
                            "\t</td>\n";
                }
            } else if (line.contains("displayName")) {

                Matcher matcher = patternD.matcher(line);
                if (matcher.matches()) {
                    headerStr =headerStr + "        <th style=\"width: 20%;\">"+matcher.group(1)+"</th> \n";
                }
            }

        }
        headerStr =headerStr+"</tr>\n" +
                "</thead>\n";
        bodyStr = bodyStr +operationStr+
                "</tr>\n" +
                "</tbody>\n" +
                "</table>";
//        System.out.println(headerStr);
//        System.out.println(bodyStr);
//        System.out.println(tail);
    }
}
