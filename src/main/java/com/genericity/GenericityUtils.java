package com.genericity;
//泛型擦除补偿机制
public class GenericityUtils {
    /**
     *  new T() 报错解决
       class newInsatance 需要类有构造器。
       这种方式不推荐，请参考显示工厂
     */
    public<T> T getInstance(Class<T> tClass) throws IllegalAccessException, InstantiationException {
        return tClass.newInstance();
    }


    /**
     *  obj instanceof T 报错
     }
     */
    public <T> boolean isInstnaceOf(Object object,Class<T> kind){
            return kind.isInstance(object);
    }

}
