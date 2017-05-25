package com.gy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by KEASON on 2017/5/18.
 */
public class DynamicProxy implements InvocationHandler {
    Object target;
    public DynamicProxy(Object target) {
        super();
        this.target = target;//注意此处的target，设定需要被代理的对象。
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        if (method.getName().equals("getName")) {
            System.out.println("before getName");
            Object o= method.invoke(target,args);
            System.out.println("after getName");
            return o;
        }else{
            return method.invoke(target,args);
        }
    }

    public static void main(String[] args) {
        UserInterface userInterfaceImpl = new UserInterfaceImpl();
        InvocationHandler invocationHandler = new DynamicProxy(userInterfaceImpl);
        //be care, three params , 第一个是被代理的类的classLoader， 第二个参数 被代理类说实现的接口， 第三个参数自己实现的InvocationHandler类的实例
        UserInterface userInterface1 = (UserInterface) Proxy.newProxyInstance(userInterfaceImpl.getClass().getClassLoader(),userInterfaceImpl.getClass().getInterfaces(),invocationHandler);
        System.out.println(userInterface1.getName());
        System.out.println(userInterface1.getId());
    }
}
