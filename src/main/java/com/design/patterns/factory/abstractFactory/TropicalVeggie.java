package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 * 具体产品
 */
public class TropicalVeggie implements Veggie {
    private String name;

    public TropicalVeggie(String name) {
        this.name = name;
    }

    public String getName() {
        return "TropicalFruit:"+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
