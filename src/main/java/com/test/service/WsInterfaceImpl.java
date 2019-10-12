package com.test.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * Created by KEASON on 2017/5/27.
 */
@WebService
public class WsInterfaceImpl implements WsInterface{
    @WebMethod
    public String sayHello() {
        return "keason ,say hello to you";
    }
}
