package com.eventbus;

import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.Subscribe;

public class EventBusListener {
    @Subscribe
    public void showLog(String map) {
        System.out.println("com.eventbus.EventBusListener.showLog " + JSON.toJSONString(map));
    }
}
