package com.design.patterns.builder;

/**
 * Created by keason on 2017/11/26.
 */
public abstract class Builder {
    public abstract void init();
    public abstract void buildPart1();
    public abstract void buildPart2();
    public abstract Product retrieveProduct();
}
