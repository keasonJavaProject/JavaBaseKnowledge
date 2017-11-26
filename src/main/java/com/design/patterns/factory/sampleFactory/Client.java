package com.design.patterns.factory.sampleFactory;


/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Client {
    public static void main(String[] args) {
        try {
            Fruit fruit = FruitGardener.factory("apple");
            fruit.plant();
            fruit.grow();
            fruit.harvest();
            System.out.println();

            Fruit grape = FruitGardener.factory("grape");
            grape.plant();
            grape.grow();
            grape.harvest();
            System.out.println();


            //直接new Fruit 接口，实现相应方法
            Fruit me = FruitGardener.factory("mebyName");
            me.plant();
            me.grow();
            me.harvest();
            System.out.println();

            Fruit no = FruitGardener.factory("no");
            no.plant();
            no.grow();
            no.harvest();
            System.out.println();

        } catch (BadFruitException e) {
            e.printStackTrace();
        }
    }
}
