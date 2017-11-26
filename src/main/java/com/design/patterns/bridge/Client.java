package com.design.patterns.bridge;

public class Client {
    public static void main(String[] args) {
        Monkey monkeyS = new ServerMonkey();
        Monkey monkeyM = new MobileMonkey();
        Platform platform = new WindowsPlatform(monkeyS);
        platform.program();
        platform = new WindowsPlatform(monkeyM);
        platform.program();

        platform = new LinuxPlatform(monkeyS);
        platform.program();

        platform = new LinuxPlatform(monkeyM);
        platform.program();

    }
}