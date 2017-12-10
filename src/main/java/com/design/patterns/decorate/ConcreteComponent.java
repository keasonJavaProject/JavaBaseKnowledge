package com.design.patterns.decorate;

public class ConcreteComponent implements Component {

    @Override
    public void sampleOperation() {
        System.out.println("first decorator");
    }

}