package com.eventbus;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.eventbus.EventBus;

import java.util.Map;

/**
 * 参考文档 EventBus
 * {@link "https://blog.csdn.net/wangdong5678999/article/details/80561198"}
 *
 * google collections
 * {@link "http://ifeve.com/google-guava-collectionutilities/"}
 */
public class MyEventBusTest {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new EventBusListener());

        Map map = ImmutableMap.of(1, 2, 3, 4);
        eventBus.post(JSON.toJSONString(map));
    }
}
