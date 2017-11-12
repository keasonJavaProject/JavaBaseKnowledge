package com.design.patterns.factory.factoryMethod;



/**
 * Created by PicaHelth on 2017/11/12.
 * 具体建造者
 */
public class GrapeFruitGardener implements FruitGardener {
    @Override
    public Fruit factory() {
        return new Grape();
    }
}
