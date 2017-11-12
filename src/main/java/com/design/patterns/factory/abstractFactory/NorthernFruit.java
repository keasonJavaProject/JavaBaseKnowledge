package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class NorthernFruit implements Fruit {
    private String name;

    public NorthernFruit(String name) {
        this.name = name;
    }

    public String getName() {
        return "NorthernFruit:"+ name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
