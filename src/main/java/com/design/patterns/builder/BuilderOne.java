package com.design.patterns.builder;

/**
 * Created by keason on 2017/11/26.
 */
public class BuilderOne extends Builder {
    private Product product;
    @Override
    public void init() {
        product = new ProductOne();
    }

    @Override
    public void buildPart1() {
        product.buildPart1(1);
    }

    @Override
    public void buildPart2() {
        product.buildPart2("hello");
    }

    @Override
    public Product retrieveProduct() {
        return product;
    }
}
