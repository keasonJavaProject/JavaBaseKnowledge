package com.design.patterns.bridge;

class ServerMonkey extends Monkey {
    @Override
    public void type() {
        System.out.print("服务器攻城狮");
    }
}
