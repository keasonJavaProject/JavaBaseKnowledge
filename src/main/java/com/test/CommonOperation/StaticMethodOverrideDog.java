package com.test.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/10.
 */
public class StaticMethodOverrideDog {
    public static void main(String[] args) {
        StaticMethodOverride_dog1 dog1 =new StaticMethodOverride_dog1();
        dog1.bark();

        //这看似静态方法override，但是并不是我们想象的那样，静态方法执行不存在动态分配机制。只与类名相关
        StaticMethodOverride_dog1 dog2 =new StaticMethodOverride_dog2();
        dog2.bark();

        StaticMethodOverride_dog2 dog2_1 =new StaticMethodOverride_dog2();
        dog2_1.bark();
    }
}
