package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/6/6.
 */
public class TryCatchFinally {
    //返回 1
    static int getV1(int a,int b){
        try{
            return  1;    //1
        }catch(Exception e){
//            return 2;    //2
        }finally{
//            return 3;   //3
        }
        return 6;       //4
    }

    //返回 1
    static int getV2(int a,int b){
        try{
            return  1;    //1
        }catch(Exception e){
            return 2;    //2
        }finally{
//            return 3;   //3
        }
//        return 6;       //4
    }

    //返回 3
    static int getV3(int a,int b){
        try{
            return  1;    //1
        }catch(Exception e){
//            return 2;    //2
        }finally{
            return 3;   //3
        }
//        return 6;       //4
    }

    //返回 3
    static int getV4(int a,int b){
        try{
            return  1;    //1
        }catch(Exception e){
            return 2;    //2
        }finally{
            return 3;   //3
        }
//        return 6;       //4
    }

    //此时返回的值 2
    static int getV5(int a,int b){
        try{
            return  1/0;    //1
        }catch(Exception e){
            return 2;    //2
        }finally{
//            return 3;   //3
        }
//        return 6;       //4
    }

    //此时返回的值 3
    static int getV6(int a,int b){
        try{
            return  1/0;    //1
        }catch(Exception e){
//            return 2;    //2
        }finally{
            return 3;   //3
        }
//        return 6;       //4
    }

    //此时返回的值 3
    static int getV7(int a,int b){
        try{
            return  1/0;    //1
        }catch(Exception e){
            return 2;    //2
        }finally{
            return 3;   //3
        }
//        return 6;       //4
    }

    //此时返回的值 4
    static int getV8(int a,int b){
        try{
            return  1/0;    //1
        }catch(Exception e){
//            return 2;    //2
        }finally{
//            return 3;   //3
        }
        return 4;       //4
    }

    public static void main(String[] args) {
        System.out.println("V1:"+getV1(1,1));
        System.out.println("V2:"+getV2(1,1));
        System.out.println("V3:"+getV3(1,1));
        System.out.println("V4:"+getV4(1,1));
        System.out.println("V5:"+getV5(1,1));
        System.out.println("V6:"+getV6(1,1));
        System.out.println("V7:"+getV7(1,1));
        System.out.println("V8:"+getV8(1,1));
    }
}
