package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class NorthernVeggie implements Veggie {
    private String name;

    public NorthernVeggie(String name) {
        this.name =name;
    }

    public String getName() {
        return "NorthernVeggie:"+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
