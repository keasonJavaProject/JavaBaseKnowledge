package com.design.patterns.factory.sampleFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 * 具体产品
 */
public class Apple implements Fruit {
    private int treeAge;
    @Override
    public void grow() {
        System.out.println("apple is growing....");
    }

    @Override
    public void harvest() {
        System.out.println("apple has been  harvested....");

    }

    @Override
    public void plant() {
        System.out.println("apple has been planted");
    }

    public int getTreeAge() {
        return treeAge;
    }

    public void setTreeAge(int treeAge) {
        this.treeAge = treeAge;
    }
}
