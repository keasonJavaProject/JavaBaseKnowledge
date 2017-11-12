package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class TropicalFruit implements Fruit {
    private String name;

    public TropicalFruit(String name) {
        this.name = name;
    }

    public String getName() {
        return "TropicalFruit:"+name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
