package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 * 具体建造者
 */
public class TropicalGardener implements Gardener {
    //水果
    public Fruit createFruit(String name) {
        return new TropicalFruit(name);
    }

    //蔬菜
    public Veggie createVeggie(String name) {
        return new TropicalVeggie(name);
    }
}
