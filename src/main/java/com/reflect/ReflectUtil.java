package com.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by keason on 2017/11/26.
 */
public class ReflectUtil {

    //获取类中定义的字段
    public static Field[] getAllFields(Class tClass) {
        if (tClass == null) {
            return new Field[]{};
        }
        return tClass.getDeclaredFields();
    }

    //获取类中所有非空字段。
    public static Map getAllValueWithoutNull(Object object) throws IllegalAccessException {
        Class tClass = object.getClass();
        Field[] fields = getAllFields(tClass);
        Map map = new HashMap();
        Object fieldValue = "";
        for (Field field : fields) {
            field.setAccessible(true);

            //这种方法，不会调用类的get方法。
            fieldValue = field.get(object);
            if (fieldValue !=null) {
                map.put(field.getName(),fieldValue);
            }
        }
        return map;
    }


    //获取类中所有非空字段,通过get方法调用。
    public static Map getAllValueWithoutNullTwo(Object object) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Class tClass = object.getClass();
        Field[] fields = getAllFields(tClass);
        Map map = new HashMap();
        Object fieldValue = "";
        for (Field field : fields) {
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), tClass);
            Method methodR  = pd.getReadMethod();//get放法
            Method methodW  = pd.getWriteMethod();//set 方法

            fieldValue = methodR.invoke(object);
            System.out.println("methodR:"+fieldValue);

            if (field.getName().equals("id")) {
                methodW.invoke(object,1222);//调用set方法，改变值
                fieldValue = methodR.invoke(object);
                System.out.println("methodW -methodR: " + fieldValue);//验证值是否已经改变
            }

            if (fieldValue !=null) {
                map.put(field.getName(),fieldValue);
            }
        }
        return map;
    }
}
