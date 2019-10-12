package com.test.service;

import javax.xml.ws.Endpoint;

/**
 * Created by KEASON on 2017/5/27.
 */
public class WsPublish {
    public static void main(String[] args) {
        Object  wsInterface = new WsInterfaceImpl();
        String address ="http://localhost:8989/SayHello";
        Endpoint.publish(address,wsInterface);
        System.out.println("发布成功");
    }
}
