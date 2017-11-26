package com.design.patterns.bridge;

class WindowsPlatform extends Platform {
    public WindowsPlatform(Monkey monkey) {
        this.mMonkey = monkey;
    }

    @Override
    public void program() {
        mMonkey.type();
        System.out.println("使用Windows平台！");
    }
}