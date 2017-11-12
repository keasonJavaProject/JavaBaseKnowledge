package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class NorthernGardener implements Gardener {
    //水果
    public Fruit createFruit(String name) {
        return new NorthernFruit(name);
    }

    //蔬菜
    public Veggie createVeggie(String name) {
        return new NorthernVeggie(name);
    }
}
