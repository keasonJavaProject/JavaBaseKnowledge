package com.test.nio;

import com.alibaba.fastjson.JSON;
import javafx.beans.property.Property;
import org.apache.commons.lang3.CharSet;

import javax.sound.midi.Soundbank;
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.CountDownLatch;

/**
 * Created by PicaHelth on 2017/7/28.
 */
public class MyCharsetTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        Charset charset = StandardCharsets.UTF_8;
        Iterator<String> iterator = charset.aliases().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}


