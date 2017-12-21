package com.design.patterns.decorate;

public class ConcreteDecoratorA extends Decorator {

    public ConcreteDecoratorA(Component component) {
        super(component);
    }
    
    @Override
    public void sampleOperation() {
        super.sampleOperation();
        System.out.println("ConcreteDecoratorA");
    }
}