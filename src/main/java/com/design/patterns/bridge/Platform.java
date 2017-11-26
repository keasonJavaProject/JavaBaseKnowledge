package com.design.patterns.bridge;

abstract class Platform {
    //定义好，骨架应用Monkey类型对象
    protected Monkey mMonkey;

    public abstract void program();
}