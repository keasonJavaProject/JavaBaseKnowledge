package com.lamba;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class MyOption {
    public static void main(String[] args) {
        Optional optional = Optional.empty();
        Optional optional1 = Optional.ofNullable(null);
        /**
         * Exception in thread "main" java.util.NoSuchElementException: No value present
         *         if (value == null) {
         *             throw new NoSuchElementException("No value present");
         *         }
         * System.out.println(optional.get());
         */
        System.out.println("\nOptional.empty() 和 Optional.ofNullable(null) 一样的");
        System.out.println(optional);
        System.out.println(optional1);

        if (!optional.isPresent()) {//value != null
            System.out.println("\noptional value is null");
            optional = Optional.of(Arrays.asList(1, 2, 3));
            showMembers((List) optional.get(),"!optional.isPresent()");

            optional.ifPresent((Consumer<List>) list -> {
                showMembers(list,"optional.ifPresent(Consumer)");
            });

            // return value != null ? value : other;
            showMembers((List) optional.orElse(Arrays.asList(3, 4, 5)),"optional.orElse not null");
            optional = Optional.empty();
        }

        // return value != null ? value : other;
        showMembers((List) optional.orElse(Arrays.asList(3, 4, 5)),"optional.orElse null");

        //return value != null ? value : other.get();
        showMembers((List) optional.orElseGet(new Supplier() {
            @Override
            public Object get() {
                return Arrays.asList(4, 5, 6);
            }
        }),"optional.orElseGet()");


        //optional.map 不会报空指针异常
        /**
         * Objects.requireNonNull(mapper);
         *         if (!isPresent())
         *             return empty();
         *         else {
         *             return Optional.ofNullable(mapper.apply(value));
         *         }
         */
        Object objectMapOrElse = getOptionFunction(optional);
        showMembers((List) objectMapOrElse,"optional.map orElse with null value");

        optional = Optional.of(Arrays.asList(1, 2, 3));
        objectMapOrElse = getOptionFunction(optional);
        showMembers((List) objectMapOrElse,"optional.map orElse with not null value");


        /**
         *  取得list里边第一个的Name
         */
        System.out.println("\n取得list里边第一个的Name");
        List<MyEntity> myEntityList = new ArrayList<>();
        myEntityList.add(null);
        if (CollectionUtils.isNotEmpty(myEntityList)) {
            MyEntity myEntity = myEntityList.get(0);
            if (myEntity != null) {
                System.out.println(myEntity.getName());
            } else {
                System.out.println("nullName");
            }
        }

        System.out.println(Optional.ofNullable(myEntityList).filter(list -> CollectionUtils.isNotEmpty(list)).
                map(list -> list.get(0)).map(info -> info.getName()).orElse("nullName"));


    }

    private static Object getOptionFunction(Optional optional) {
        return optional.map(new Function<List, List>() {
                @Override
                public List apply(List list) {
                    return (List) list.stream().map(object -> {
                        Integer intt = (Integer) object;
                        intt += 1;
                        return intt;
                    }).collect(Collectors.toList());
                }
            }).orElse(Arrays.asList(5, 6, 7));
    }

    private static void showMembers(List list, String msg) {
        System.out.println("\nshowMembers " + msg);
        list.forEach(info -> System.out.println(info));
    }
}
