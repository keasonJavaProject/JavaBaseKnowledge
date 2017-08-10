package com.gy.nio;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.CharSet;

import java.nio.charset.Charset;

/**
 * Created by PicaHelth on 2017/7/28.
 */
public class MyCharsetTest {
    public static void main(String[] args) {
        System.out.println(Charset.defaultCharset());
        System.out.println(JSON.toJSONString(Charset.availableCharsets()));
        String name = "严涛";
        Charset charset = Charset.forName("utf-8");
        Charset charset1 = Charset.forName("gbk");
        System.out.println(charset1.decode(charset.encode(name)));
    }
}
