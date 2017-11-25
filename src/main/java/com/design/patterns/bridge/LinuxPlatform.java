package com.design.patterns.bridge;

class LinuxPlatform extends Platform {
    public LinuxPlatform(Monkey monkey) {
        this.mMonkey = monkey;
    }

    @Override
    public void program() {
        mMonkey.type();
        System.out.println("使用Linux平台！");
    }
}