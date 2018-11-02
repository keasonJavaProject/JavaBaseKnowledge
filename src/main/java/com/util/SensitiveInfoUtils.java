package com.util;


import com.google.common.base.Joiner;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 号码掩码显示
 */
public class SensitiveInfoUtils {




    /**
     * [手机号码] 前三位，后四位，其他隐藏<例子:138******1234>
     *
     * @param num
     * @return
     */
    public static String mobilePhone(String num) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.left(num, 3).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(num, 4), StringUtils.length(num), "*"), "***"));
    }


    /**
     * [身份证号 银行卡] 显示最后四位，其他隐藏。共计18位或者15位。<例子：*************5762>
     *
     * @param id
     * @return
     */
    public static String idCardNum(String id) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        String num = StringUtils.right(id, 4);
        return StringUtils.leftPad(num, StringUtils.length(id), "*");

    }


    /**
     * [银行卡号] 前六位，后四位，其他用星号隐藏每位1个星号<例子:6222600**********1234>
     *
     * @param cardNum
     * @return
     */
    public static String bankCard(String cardNum) {
        if (StringUtils.isBlank(cardNum)) {
            return "";
        }
        return StringUtils.left(cardNum, 6).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(cardNum, 4), StringUtils.length(cardNum), "*"), "******"));
    }

    /**
     * [公司开户银行联号] 公司开户银行联行号,显示前两位，其他用星号隐藏，每位1个星号<例子:12********>
     *
     * @param code
     * @return
     */
    public static String cnapsCode(String code) {
        if (StringUtils.isBlank(code)) {
            return "";
        }
        return StringUtils.rightPad(StringUtils.left(code, 2), StringUtils.length(code), "*");
    }

    /**
     *
     * 功能:批量掩码逗号分隔的手机号
     * 描述:
     *
     * @param:
     * @return:
     */
    public static  String mobilePhoneList(String phoneList){
        List<String> strings = Arrays.asList(phoneList.split(","));
        ArrayList<String> nowList = new ArrayList<>();
        for (String string : strings) {
            String s = mobilePhone(string);
            nowList.add(s);
        }
        if(nowList.size()>0){
            return Joiner.on(",").join(nowList);
        }
        return "";
    }

    public static void main(String[] args) {
        String str = "1111222223333";
        System.out.println(StringUtils.leftPad(str, 20,"|"));
        System.out.println(StringUtils.leftPad(str, 5,"|"));

        System.out.println(StringUtils.rightPad(str, 20,"|"));

        System.out.println(mobilePhoneList("15971859365,15971859366"));

    }


}
