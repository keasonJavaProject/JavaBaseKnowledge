package com.genericity;


import java.util.ArrayList;
import java.util.List;

public class GenericityFatherChild {
    public static void main(String[] args) {
        List<Number> listn= new ArrayList<Number>();
        listn.add(1);
        listn.add(2.01);


        List<Integer> listI= new ArrayList<Integer>();
        listI.add(1);
        listI.add(2);

        System.out.println("genericity type");
        showData(listn);
        System.out.println("error compiler");
        //编译报错 showData(listI);


        System.out.println("\n list? type");
        showDataE(listn);
        showDataE(listI);

        System.out.println("\n listObject error");
//        showDataO(listn);
//        showDataO(listI);


        System.out.println("\n listNull");
        showDataL(listn);
        showDataL(listI);
    }


    public static void showData(List<Number> list) {
        System.out.println(list.toString());
    }

    public static void showDataE(List<?> list) {
        System.out.println(list.toString());
    }

    public static void showDataO(List<Object> list) {
        System.out.println(list.toString());
    }

    public static void showDataL(List list) {
        System.out.println(list.toString());
    }
}
