package com.design.patterns.visitor;

/**
 * Created by PicaHelth on 2017/11/12.
 * 抽象节点方法
 */
public abstract class Equipment {
    public abstract void accept(Visitor visitor);
    public abstract double price();
}
