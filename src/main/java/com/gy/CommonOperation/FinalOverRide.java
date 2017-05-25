package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/5/25.
 */
public class FinalOverRide {

    public String  getId(){
        return "id";
    }
     public final String  getName(){
        return "name";
     }

     private class InnerClass extends FinalOverRide{
        @Override
         public String getId(){
            return "innerId";
         }

//不管写不写override,都会编译报错，提示不能复写final方法。
//         @Override
//         public String getName(){
//             return "innerName";
//         }
    }
}
