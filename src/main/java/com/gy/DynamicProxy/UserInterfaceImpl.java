package com.gy.DynamicProxy;

/**
 * Created by KEASON on 2017/5/18.
 */
public class UserInterfaceImpl implements UserInterface {
    public String getName() {
        System.out.println("getName");
        return "keason";
    }

    public String getId() {
        System.out.println("getId");
        return "keason001";
    }
}
