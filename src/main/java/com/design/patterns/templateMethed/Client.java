package com.design.patterns.templateMethed;

public class Client {
    public static void main(String[] args) {
        AbstractClass abstractClass = new AbstractImplClass();
        abstractClass.TemplateMethod();
    }
}
