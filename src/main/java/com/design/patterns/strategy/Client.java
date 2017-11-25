package com.design.patterns.strategy;

public class Client {
    public static void main(String[] args) {
        Context context = new Context(new BackDoor());
        context.operate();

        context =new Context(new GivenGreenLight());
        context.operate();

        context =new Context(new Strategy() {
            @Override
            public void operate() {
                System.out.println("now is the time");
            }
        });
        context.operate();

    }
}
