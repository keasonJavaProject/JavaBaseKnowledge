package com.genericity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

//泛型擦除补偿机制
public class GenericityUtils {
    /**
     *  new T() 报错解决
       class newInsatance 需要类有构造器。
       这种方式不推荐，请参考显示工厂
     */
    public static  <T> T getInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }

    public static <T> T[] getArray(Class<T> tClass,int size) {
       return (T[])  Array.newInstance(tClass, size);
    }

    public static <T> List<T> getList(Class<T> tClass) {
        return new ArrayList<T>();
    }


    /**
     *  obj instanceof T 报错
     }
     */
    public static <T> boolean isInstnaceOf(Object object,Class<T> kind){
            return kind.isInstance(object);
    }

}
