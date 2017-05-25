package com.gy.CommonOperation;

/**
 * Created by KEASON on 2017/5/24.
 * 在TIJ中，说了，只有for()支持逗号运算符。同事计算多列
 */
public class CommonOperationSerach {
    public static void main(String[] args) {
        int needValue = 3;
        int [] temp ={1,2,3,4};
        for(int i=0;i<temp.length && temp[i]!=5;i++){
            System.out.println("i:"+i+"     value:"+temp[i]);
        }

        ////////////////////////////////////////////
        int i;
        for(i=0;i<temp.length && temp[i]!= needValue;i++){//当判断为false时就立即停止了
        }
        if(i<temp.length){
            System.out.println("for() find one");
        }

        /////////////////////////////////////////////
        boolean forFindTwo = false;
        for(int j=0;j<temp.length;j++){
            if(temp[j]==needValue){
                forFindTwo = true;
                break;
            }
        }
        if(forFindTwo){
            System.out.println("for() find two");
        }

        //////////////////////////////////////
        int loop =0;
        while(loop<temp.length && temp[loop]!=needValue){
            loop++;
        }
        if(loop<temp.length){
            System.out.println("while,find one");
        }

        //////////////////////////////////////////
        int m =-1;
        do{
            m++;
        }while(m<temp.length && temp[m]!=needValue);
        if(m<temp.length){
            System.out.println("do while find one");
        }

        ////////////////////////////
        //多定义一个值，放最后，做教研查询
        int [] temp1 ={1,2,3,4,};
        temp1[temp1.length-1]=needValue;
        int index=0;
        while(temp1[index]!=needValue){//while 条件中，只用一个if
            index++;
        }
        if(index!=temp1.length-1){
            System.out.println("find data in on if ");
        }
    }
}
