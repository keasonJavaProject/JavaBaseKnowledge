package com.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2019/2/17 08:54
 */
public class MyJsonViewTest {
    public static void main(String[] args) throws JsonProcessingException {
        MyJsonView myJsonView = new MyJsonView(1, "hello", "keason");
        //###################################jackson view
        String resultPublic = new ObjectMapper()
                .writerWithView(MyJsonView.Public.class)
                .writeValueAsString(myJsonView);
        System.out.println(resultPublic);

        String resultInternal = new ObjectMapper()
                .writerWithView(MyJsonView.Internal.class)
                .writeValueAsString(myJsonView);
        System.out.println(resultInternal);


        //#########################################jackson filter
       /* 1.filter 必须先定义
        2.再定义 对象，不让说找不到*/
        FilterProvider filters
                = new SimpleFilterProvider().addFilter(
                "myFilter",
                SimpleBeanPropertyFilter.filterOutAllExcept("id"));
        MyJsonViewFilter myJsonViewFilter = new MyJsonViewFilter(1, "hello", "keason");

        String resultFilter = new ObjectMapper()
                .writer(filters)
                .writeValueAsString(myJsonViewFilter);
        System.out.println(resultFilter);
    }
}
