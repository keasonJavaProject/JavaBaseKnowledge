package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 * 抽象建造者
 */
public interface Gardener {
    Fruit createFruit(String name);
    Veggie createVeggie(String name);
}

