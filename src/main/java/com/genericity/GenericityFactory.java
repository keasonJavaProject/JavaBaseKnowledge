package com.genericity;

public interface GenericityFactory<T> {
    T create();

    //工厂方法
    class Foo<T> {
        private T x;
        public <F extends GenericityFactory<T>> Foo(F factory) {
            x = factory.create();
        }

        public T getX() {
            return x;
        }
    }

    class IntegerFactory implements GenericityFactory<Integer>{
        @Override
        public Integer create() {
            return Integer.valueOf(-1);
        }
    }

    class StringFactory implements GenericityFactory<String>{
        @Override
        public String create() {
            return "-1";
        }
    }

    public static void main(String[] args) {
        System.out.println(new Foo<Integer>(new IntegerFactory()).getX());

        System.out.println(new Foo<String>(new GenericityFactory<String>() {
            @Override
            public String create() {
                return "FactoryString";
            }
        }).getX());
    }
}
