package com.gy.CommonOperation;

/**
 * Created by PicaHelth on 2017/8/15.
 */
public class MethodOverride {
    protected class MethodOveride {
        protected void OMethod() {
            System.out.println("hello");
        }

        public void OMethod1() {
            System.out.println("hello1");
        }
    }

    public class MethodOveride1 extends MethodOveride {
        @Override
        public void OMethod() {
            System.out.println("hello");
        }

        @Override
        public void OMethod1() {//使用private 或者 protect 会报错，复写方法的访问权限>= 被复写方法的访问权限
            System.out.println("hello1");
        }
    }
}
