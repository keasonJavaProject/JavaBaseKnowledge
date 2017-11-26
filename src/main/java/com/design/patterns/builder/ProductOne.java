package com.design.patterns.builder;

/**
 * Created by keason on 2017/11/26.
 */
public class ProductOne implements Product {
    private int id;
    private String name;

    @Override
    public String toString() {
        return "ProductOne{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public void buildPart1(int id) {
        this.id = id;
    }

    @Override
    public void buildPart2(String name) {
        this.name = name;
    }
}
