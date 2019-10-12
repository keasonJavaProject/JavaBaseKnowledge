package com.test.CommonOperation.innerClass;

/**
 * 内部类，实现多重继承
 */
public class MainExample {

    public static void main(String args[])

    {

        MainExample mi = new MainExample();

        System.out.println("姓名:" + mi.name());

        System.out.println("年龄:" + mi.age());

    }

    private class test1 extends Example1 {

        public String name()

        {

            return super.name();

        }

    }

    private class test2 extends Example2 {

        public int age()

        {

            return super.age();

        }

    }

    public String name()

    {

        return new test1().name();

    }

    public int age()

    {

        return new test2().age();

    }
}