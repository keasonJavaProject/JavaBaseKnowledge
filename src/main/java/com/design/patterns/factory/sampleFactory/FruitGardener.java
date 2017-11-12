package com.design.patterns.factory.sampleFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 * 建造者
 */
public class FruitGardener {
    public static Fruit factory(String type) throws BadFruitException{
        if ("apple".equals(type)) {
            return new Apple();

        } else if ("grape".equals(type)) {
            return new Grape();

        } else if (type.contains("byName")) {
            return new Fruit() {
                @Override
                public void grow() {
                    System.out.println(type.replaceAll("byName","")+" is growing....");
                }

                @Override
                public void harvest() {
                    System.out.println(type.replaceAll("byName","")+" has been harvested....");
                }

                @Override
                public void plant() {
                    System.out.println(type.replaceAll("byName","")+" has been planted....");
                }
            };

        } else {
            throw new BadFruitException("bad fruit request");
        }
    }
}
