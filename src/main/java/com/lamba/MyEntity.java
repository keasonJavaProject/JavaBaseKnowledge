package com.lamba;

import com.gy.jsonView.Student;

import java.util.List;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/2 16:58
 */
public class MyEntity {
    private Integer id;
    private String name;
    private List<MyEntity> list;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyEntity(Integer id, String name, List<MyEntity> list) {
        this.id = id;
        this.name = name;
        this.list = list;
    }

    public List<MyEntity> getList() {
        return list;
    }

    public void setList(List<MyEntity> list) {
        this.list = list;
    }
}
