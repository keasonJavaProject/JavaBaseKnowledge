package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/6/5.
 */
public class AbstractChildMethod  extends AbstractMethod{
    String temp = "B";
    private String tempa = "BB";

    public AbstractChildMethod(){
        System.out.println("construct"+temp);
    };
    @Override
    void showM1() {
        System.out.println("AbstractChildMethod showM()");
    }
    //报错，abstract method can not have body
//    abstract void showM(){};

    public static void main(String[] args) {
//        如果父子同事有相同的变量名称，则最终返回的只是子的变量的值，所以输出B
        System.out.println(new AbstractChildMethod().temp);
        System.out.println(new AbstractChildMethod().getTempa());//这里边输出的值是AA,如果子类中有一个覆盖父类的方法getTempa(),则返回的是BB
     }
}
