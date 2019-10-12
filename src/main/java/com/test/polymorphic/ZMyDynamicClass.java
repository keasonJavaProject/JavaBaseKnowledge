package com.test.polymorphic;

/**
 * Created by PicaHelth on 2017/9/13.
 */
public class ZMyDynamicClass {
    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("hello man!");
    }
    public void sayHello(Woman guy) {
        System.out.println("hello woman!");
    }


    //多态
    public void sayHelloDynamic(Human guy) {
        guy.show();
    }



    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        ZMyDynamicClass ZMyDynamicClass = new ZMyDynamicClass();
        //编译器根据参数的静态类型决定使用哪个重载版本[根据参数类型]
        ZMyDynamicClass.sayHello(man);
        ZMyDynamicClass.sayHello(woman);

        //静态类型变化
        ZMyDynamicClass.sayHello((Man)man);
        ZMyDynamicClass.sayHello((Woman) woman);



        //多态
        ZMyDynamicClass.sayHelloDynamic(man);
        ZMyDynamicClass.sayHelloDynamic(woman);
    }

}
