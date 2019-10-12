package com.test.lamda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by PicaHelth on 2017/9/14.
 */
public class MyOptional {
    private static class InnerClass {
        String name;
        List<String> list = Arrays.asList(null,"1","2",null,"3");

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getList() {
            return list;
        }

        public void setList(List<String> list) {
            this.list = list;
        }
    }

    public static void main(String[] args) {
        InnerClass innerClass = new InnerClass();
        Optional<String> oName = Optional.ofNullable(innerClass.name);
        String userName  = oName.orElse("keason");
        System.out.println(userName);


        Optional<InnerClass> oInnerClass = Optional.ofNullable(innerClass);

        List<String> oList = oInnerClass.map(oInn->oInn.getList()).orElse(new ArrayList<>());
        System.out.println(oList.toString());


//        oList = oList.stream().map(val->val+"222").collect(Collectors.toList());
        oList = oList.stream().map((val) ->{
            if (val == null) {
                return "XX";
            } else {
                return val+"OO";
            }

        }).collect(Collectors.toList());

        System.out.println(oList.toString());


    }
}
