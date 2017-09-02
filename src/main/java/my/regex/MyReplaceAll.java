package my.regex;

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

    }

}
