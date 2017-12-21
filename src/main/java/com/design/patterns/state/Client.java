package com.design.patterns.state;

/**
 * Created by keason on 2017/12/10.
 */
public class Client {
    public static void main(String[] args) {
        State rain = new  Rain();
        State sunshine = new Sunshine();
        new Client().desideWich(rain);
        new Client().desideWich(sunshine);
    }

    //更具不同的状态，自动调用多态方法
    private void desideWich(State state) {
        System.out.println(state.getState());//多态，自动调用
    }
}
