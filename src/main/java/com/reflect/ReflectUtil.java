package com.reflect;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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






    /**
     * 获取两个对象同名属性内容不相同的列表
     * @param class1 对象1
     * @param class2 对象2
     * @return
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     */
    public static List<Map<String ,Object>> compareTwoClass(Object class1,Object class2) throws ClassNotFoundException, IllegalAccessException {
        List<Map<String,Object>> list=new ArrayList<Map<String, Object>>();
        //获取对象的class
        Class<?> clazz1 = class1.getClass();
        Class<?> clazz2 = class2.getClass();
        //获取对象的属性列表
        Field[] field1 = clazz1.getDeclaredFields();
        Field[] field2 = clazz2.getDeclaredFields();
        //遍历属性列表field1
        for(int i=0;i<field1.length;i++){
        //遍历属性列表field2
            for(int j=0;j<field2.length;j++){
                     //如果field1[i]属性名与field2[j]属性名内容相同
                    if(field1[i].getName().equals(field2[j].getName())){
                        field1[i].setAccessible(true);
                        field2[j].setAccessible(true);
                         //如果field1[i]属性值与field2[j]属性值内容不相同
                        if (!compareTwo(field1[i].get(class1), field2[j].get(class2))){
                            Map<String,Object> map2=new HashMap<String, Object>();
                            map2.put("name",field1[i].getName());
                            map2.put("old",field1[i].get(class1));
                            map2.put("new",field2[j].get(class2));
                            list.add(map2);
                        }
                        break;
                    }
                }
        }
        return list;
    }

    /**
     * 对比两个数据是否内容相同
     *
     * @param  object1,object2
     * @return boolean类型
     */
    public static boolean compareTwo(Object object1,Object object2){

        if(object1==null&&object2==null){
            return true;
        }
        if(object1==null&&object2!=null){
            return false;
        }
        if(object1.equals(object2)){
            return true;
        }
        return false;
    }

}
