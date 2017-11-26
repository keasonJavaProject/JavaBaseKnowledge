package com.design.patterns.factory.factoryMethod;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Client {
    public static void main(String[] args) {
        Fruit apple = new AppleFruitGardener().factory();
        apple.plant();
        apple.grow();
        apple.harvest();
        System.out.println();

        Fruit grape = new GrapeFruitGardener().factory();
        grape.plant();
        grape.grow();
        grape.harvest();
        System.out.println();
    }
}
