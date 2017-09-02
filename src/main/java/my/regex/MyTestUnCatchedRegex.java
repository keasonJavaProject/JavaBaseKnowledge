package my.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by PicaHelth on 2017/9/1.
 * 正则分组，测试知道 compile()
 * 1.反向引用，下表从1 开始
 * 2.java正则表达式：Group zero always stands for the entire expression.
 *
 */
public class MyTestUnCatchedRegex {

    public static void main(String[] args) {

        //反向引用 替换
        String aa = "242423sfsfsfafasf";
        aa = aa.replaceAll("(24)\\1", "XXXX");
        System.out.println(aa);

        //反向引用 正则表达式
        String str = "242423sfsfsfafasf";
        Pattern pattern=Pattern.compile("(24)\\1(.*)"); // 为了方便写正则表达式，符号有特殊颜色。
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()){
            for (int i = 0; i < matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }


        //注意 这个例子， 输出的是hope, 是因为非捕获分组，不占用扫描实际位置。
        Pattern p = Pattern.compile("(?=hopeful)hope");
        str = "hopeful";
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }


        //test1 非捕获分组， 给分组起名字
        str = "hello123123keason@163.com";
        pattern = Pattern.compile("(hello)(.*)");
        matcher = pattern.matcher(str);
        if (matcher.matches()){
            System.out.println("test2:"+matcher.group(1));
        }

        //test2
        pattern = Pattern.compile("hello(?<name>\\d+)(keason@163.com)(.*)");
        matcher = pattern.matcher(str);
        if (matcher.matches()){
            System.out.println("test1:"+matcher.group("name"));
        }

        //test3
        aa ="AAABBBCCCCCC";
        aa = aa.replaceAll("(.)\\1+", "$1");
        System.out.println("test3:"+aa);


        //test4
        String temp = "192.168.1.200 10.10.10.10 3.3.50.3 127.0.0.1";
        temp=temp.replaceAll("(\\d+)", "00$1");//00192.00168.001.00200 0010.0010.0010.0010 003.003.0050.003 00127.000.000.001
        temp=temp.replaceAll("0+(\\d{3})", "$1");//将ip地址补成同样位数  192.168.001.200 010.010.010.010 003.003.050.003 127.000.000.001
        String[] str1=temp.split(" +");
        Arrays.sort(str1);
        for(String ips:str1){
            System.out.println(ips.replaceAll("0+(\\d+)", "$1"));
        }

        //test5
        pattern = Pattern.compile("(?:(\\d+))?\\s?([a-zA-Z]+)?.+");
        String source = "2133 fdsdee4333";
        matcher = pattern.matcher(source);
        if(matcher.matches()){
            for(int i=0;i<=matcher.groupCount();i++){
                System.out.println("group "+i+":"+matcher.group(i));
            }
        }



    }
}
