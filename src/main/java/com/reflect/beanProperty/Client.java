package com.reflect.beanProperty;

import com.reflect.ReflectUtil;

import java.beans.IntrospectionException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by keason on 2017/11/26.
 */
public class Client {
    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        DataModel dataModel = new DataModel();
        dataModel.setDate(new Date());
        dataModel.setId(12);
        dataModel.setName("keason");

        Map map = ReflectUtil.getAllValueWithoutNull(dataModel);
        System.out.println(map.toString());

        map = ReflectUtil.getAllValueWithoutNullTwo(dataModel);
        System.out.println(map.toString());
    }



}
