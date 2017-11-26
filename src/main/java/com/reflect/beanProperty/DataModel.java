package com.reflect.beanProperty;

import java.util.Date;

/**
 * Created by keason on 2017/11/26.
 */
public class DataModel {
    private Integer id;
    private String name;
    private Date date;

    public Integer getId() {
        System.out.println("hello keason ,i see you again!");
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
