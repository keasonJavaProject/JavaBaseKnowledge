package com.design.patterns.bridge;

class MobileMonkey extends Monkey {
    @Override
    public void type() {
        System.out.println("移动端攻城狮");
    }
}