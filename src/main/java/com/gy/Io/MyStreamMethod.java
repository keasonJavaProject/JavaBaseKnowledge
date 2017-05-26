package com.gy.Io;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by KEASON on 2017/5/26.
 */
public class MyStreamMethod {
   static String path ="d://localData/data.txt";

    public static void main(String[] args) throws Exception {

        File file = createOrGetFile(path);
//        FileOutputStream outputStream = new FileOutputStream(file);
//        int count =0;
//        Scanner scanner = new Scanner(System.in);
//        while(count<4){
//            System.out.println("请输入字符id："+count);
//            outputStream.write(formatLeftS(scanner.nextLine(),30).getBytes());
//            System.out.println("请输入字符name："+count);
//            outputStream.write(formatLeftS(scanner.nextLine(),30).getBytes());
//            outputStream.write(("\r\n").getBytes());
//            count++;
//        };
//        outputStream.close();
//        showAllData(path);
//        showLineById("1000");
//        showAllDataFromInputStream(path);
        showAllDataFromByteInputStream(path);
    }

    static void showLineById(String id) throws Exception {
        File file = createOrGetFile(path);
        String line ="";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        System.out.println(String.format("\r\n\r\nshowLineById(id=%s),the result is:",id));
        while ((line = bufferedReader.readLine()) != null) {
            if (line.contains(id)) {
                String lineStr [] = line.split("                          ");
                for (String str : lineStr) {
                    System.out.print(str+"  ");
                }
                System.out.println();
                break;
            }
        }

    }

    static void showAllData(String url) throws Exception {
        System.out.println("showAllDate,the result is:");
        File file = createOrGetFile(path);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line ="";
        while((line = bufferedReader.readLine())!=null){
            String lineStr [] = line.split("                          ");
            for (String str : lineStr) {
                System.out.print(str+"  ");
            }
            System.out.println();
        }
    }

    static void showAllDataFromInputStream(String url) throws Exception {
        File file = createOrGetFile(path);
        InputStream inputStream = new FileInputStream(file);
        byte [] bytes = new byte[1000];
        byte b = 0;
        int index =0;
        while ((b=(byte)inputStream.read())!=-1){
            bytes[index] = b;
            index++;
        }
        System.out.println(new String(bytes));
    }
    static void showAllDataFromByteInputStream(String url) throws Exception {
        File file = createOrGetFile(path);
        InputStream inputStream = new FileInputStream(file);
        byte [] bytes = new byte[1000];
        byte b = 0;
        int index =0;
        while ((b=(byte)inputStream.read())!=-1){
            bytes[index] = b;
            index++;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(byteArrayInputStream));
        String str ="";
        while ((str =bufferedReader.readLine())!=null) {
            System.out.println(str);
        }

    }

    static String formatLeftS(String str, int min_length) {
        String format = "%-" + (min_length < 1 ? 1 : min_length) + "s";
        return String.format(format, str);
    }

    static File createOrGetFile(String path) throws Exception {
        if(StringUtils.isEmpty(path)){
            throw new Exception("file path error");
        }
        File file = new File(path);
        if (file.exists()) {
            return file;
        } else {
            file.createNewFile();
            return file;
        }
    }
}
