package com.design.patterns.command;

public class Client {
    public static void main(String[] args) {
//        命令的具体执行者
        Receiver receiver = new Receiver();

//        具体的命令
        Command command = new ConcreteCommand(receiver);

//        具体命令执行者和具体的命令解耦
        Invoker invoker = new Invoker(command);
        invoker.action();
    }
}
