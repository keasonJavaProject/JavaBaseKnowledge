package com.design.patterns.factory.abstractFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Client {
    public static void main(String[] args) {
        Gardener gardener1 = new NorthernGardener();
        Fruit fruit1=  gardener1.createFruit("NorthernGardener fruit");
        System.out.println(fruit1.getName());
        Veggie veggie1 =gardener1.createVeggie("NorthernGardener veggie");
        System.out.println(veggie1.getName());
        System.out.println();

        Gardener gardener2 = new TropicalGardener();
        Veggie veggie2 = gardener2.createVeggie("TropicalGardener fruit");
        System.out.println(veggie2.getName());

        Fruit fruit2 = gardener2.createFruit("TropicalGardener fruit");
        System.out.println(fruit2.getName());
    }
}
