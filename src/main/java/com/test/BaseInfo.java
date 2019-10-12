package com.test;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * fastjson 对嵌套同名对象可以进行反序列化，不过要是严格意义的json（键值对，中的键要是用双引号引起来的才可以）
 */
public class BaseInfo {
    private Long id;
    private String name;
    private List<BaseInnerInfo> list = new ArrayList<BaseInnerInfo>();

    public BaseInfo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) {
        String data  ="{\n" +
                "\t\"id\": 1001,\n" +
                "\t\"name\": \"name1001\",\n" +
                "\tlist: [{\n" +
                "\t\t\t\"id\": 1002,\n" +
                "\t\t\t\"name\": \"name1002\"\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";
        BaseInfo baseInfo = JSON.parseObject(data,BaseInfo.class);
    }
    public List<BaseInnerInfo> getList() {
        return list;
    }

    public void setList(List<BaseInnerInfo> list) {
        this.list = list;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "BaseInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
