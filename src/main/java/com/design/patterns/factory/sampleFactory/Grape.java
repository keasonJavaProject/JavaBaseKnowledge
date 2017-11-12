package com.design.patterns.factory.sampleFactory;

/**
 * Created by PicaHelth on 2017/11/12.
 */
public class Grape implements Fruit {
    private boolean seederless;
    @Override
    public void grow() {
        System.out.println("grape is growing....");
    }

    @Override
    public void harvest() {
        System.out.println("grape has been  harvested....");

    }

    @Override
    public void plant() {
        System.out.println("grape has been planted");
    }

    public boolean isSeederless() {
        return seederless;
    }

    public void setSeederless(boolean seederless) {
        this.seederless = seederless;
    }
}
