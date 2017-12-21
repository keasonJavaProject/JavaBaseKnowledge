package com.design.patterns.decorate;

/**
 * Created by keason on 2017/12/10.
 */
public class Client {
    public static void main(String[] args) {
        ConcreteComponent concreteComponent = new ConcreteComponent();
        Component componentA = new ConcreteDecoratorA(concreteComponent);
        Component componentB = new ConcreteDecoratorB(componentA);
        componentB.sampleOperation();
    }
}
