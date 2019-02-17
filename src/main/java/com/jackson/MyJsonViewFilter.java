package com.jackson;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonView;

/**
 * @ClassName:
 * @Description: 实现同一个对象，定义不同的返回JSOn字段
 * 1.jackson view
 * 2.jackson filter
 * @auther: yant09
 * @date: 2019/2/17 08:52
 */
@JsonFilter("myFilter")
public class MyJsonViewFilter {
    @JsonView(Public.class)
    public int id;

    @JsonView(Public.class)
    public String itemName;

    @JsonView(Internal.class)
    public String ownerName;

    public static class Public {}
    public static class Internal extends Public {}

    public MyJsonViewFilter(int id, String itemName, String ownerName) {
        this.id = id;
        this.itemName = itemName;
        this.ownerName = ownerName;
    }
}
