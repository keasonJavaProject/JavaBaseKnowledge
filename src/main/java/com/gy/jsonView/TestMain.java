package com.gy.jsonView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //创建对象
        Student user = new Student(1001,"1001name","isea533","123456");
        //序列化
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        objectMapper.writerWithView(Student.WithoutPasswordView.class).writeValue(bos, user);
        System.out.println(bos.toString());

        bos.reset();
        objectMapper.writerWithView(Student.WithPasswordView.class).writeValue(bos, user);
        System.out.println(bos.toString());

        Map student = objectMapper.readValue(bos.toString(),Map.class);
    }
}
