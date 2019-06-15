package com.lamba;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName:
 * @Description:
 * @auther: yant09
 * @date: 2018/11/2 16:48
 */
public class MyLambda {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable(null).map(info -> info.getClass().toString()).orElse(Integer.class.toString()));
        //值转换
        System.out.println("值转换例子 \r\n");
        List<MyEntity> myEntityList = Arrays.asList(new MyEntity(22,"22",null), new MyEntity(222,"222",null));
        myEntityList = Optional.ofNullable(myEntityList).filter(infos -> CollectionUtils.isNotEmpty(infos)).orElse(Arrays.asList(new MyEntity(11, "11", null), new MyEntity(111, "111", null)))
                .stream().filter(temp -> temp.getId() > 1).collect(Collectors.toList());
        myEntityList = Stream.of(new MyEntity(2, "2",Arrays.asList(new MyEntity(22,"22",null), new MyEntity(222,"222",null))),
                new MyEntity(1, "1",Arrays.asList(new MyEntity(11,"11",null), new MyEntity(111,"111",null))),
                new MyEntity(4, "2",Arrays.asList(new MyEntity(22,"22",null), new MyEntity(222,"222",null))),
                new MyEntity(3, "3",Arrays.asList(new MyEntity(33,"33",null), new MyEntity(333,"333",null),new MyEntity(33,"33",null))))
                .collect(Collectors.toList());

        Set<String> strNames = myEntityList.stream().filter(in -> in != null).flatMap(info -> info.getList().stream()).filter((MyEntity aa) -> aa.getId() >= 2).map(MyEntity::getName).collect(Collectors.toSet());
        System.out.println(strNames);
        System.out.println("比较2个list 大小");
        System.out.println(myEntityList.stream().collect(Collectors.toList()).size());
        System.out.println(myEntityList.stream().filter(i -> i != null).collect(Collectors.toList()).size());

        //取得最多list的MyEntity 如果同时相同的比较值，最终会返回第一个遇到的最多的值
        Optional<MyEntity> optional = myEntityList.stream().collect(Collectors.maxBy(new Comparator<MyEntity>() {
            @Override
            public int compare(MyEntity o1, MyEntity o2) {
                return Integer.valueOf(o1.getList().size()).compareTo(o2.getList().size());
            }
        }));
        System.out.println(" \r\n 取得最多list的MyEntity " + JSON.toJSONString(optional.get()));


        double returnDouble = myEntityList.stream().collect(Collectors.averagingDouble(new ToDoubleFunction<MyEntity>() {
            @Override
            public double applyAsDouble(MyEntity value) {
                return Double.valueOf(value.getList().size());
            }
        }));
        System.out.println(" \r\n 取得MyEntity 里边list的平均值 " + JSON.toJSONString(returnDouble));


        System.out.println("\r\n 把 ArraysList 变成 linkList");
        LinkedList<MyEntity> linkedList = myEntityList.stream().collect(Collectors.toCollection(LinkedList::new));



        System.out.println("\r\n 三种方式实现取得name list");
        //循环list中的对象，通过optional 避免空指针异常 来取 name
        System.out.println(myEntityList.stream().map(i -> i.getName()).collect(Collectors.toList()));

        //过滤掉null的对象
        System.out.println(myEntityList.stream().filter(i -> i != null).map(i -> i.getName()).collect(Collectors.toList()));

        System.out.println(myEntityList.stream().map(i -> Optional.ofNullable(i).map(myEntity -> myEntity.getName()).orElse("null")).collect(Collectors.toList()));




        //判断对象是否为空
        MyEntity myEntity = null;
        System.out.println(Optional.ofNullable(myEntity).map(i -> i.getName()).isPresent());

        //判断对象不为空执行方法
        myEntity = new MyEntity(3, "4", null);
        Optional.ofNullable(myEntity).map(i -> i.getName()).ifPresent(i -> System.out.println(i));


        //如果对象为空则给个值
        myEntity = null;
        System.out.println(Optional.ofNullable(myEntity).map(i -> i.getName()).orElse("null"));



        //从流中获取结果
        System.out.println("从流中获取结果 \r\n");
        IntSummaryStatistics intSummaryStatistics = myEntityList.stream().mapToInt(info -> info.getList().size()).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());

        //数据分片
        System.out.println("数据分片 partitioningBy \r\n");
        Map<Boolean, List<MyEntity>> booleanListMap = myEntityList.stream().collect(Collectors.partitioningBy(info -> info.getId() > 2));
        Stream.of(booleanListMap).peek(info-> System.out.println(JSON.toJSONString(info))).forEach(info -> System.out.println(JSON.toJSONString(info)));

        System.out.println("数据分片 groupingBy 按照姓名统计List<MyEntity>\r\n");
        Map<String,List<MyEntity>> maps = myEntityList.stream().collect(Collectors.groupingBy(myEntity1 -> myEntity1.getName()));
        Stream.of(maps).peek(info-> System.out.println(JSON.toJSONString(info))).forEach(info -> System.out.println(JSON.toJSONString(info)));

        System.out.println("\n数据分片 groupingBy 按照姓名统计list数量");
        Map<String, Long> mapCount = myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
            @Override
            public String apply(MyEntity myEntity) {
                return myEntity.getName();
            }
        }, Collectors.counting()));
        System.out.println((JSON.toJSONString(mapCount)));


        System.out.println("\n计算内层的MyEntity sum");
        System.out.println(myEntityList.stream().mapToLong(info -> info.getList().stream().mapToLong(infoInner -> infoInner.getId()).count()).sum());


//        myEntityList.stream().collect(Collectors.groupingBy(new Function<MyEntity, String>() {
//            @Override
//            public String apply(MyEntity myEntity) {
//                return myEntity.getName();
//            }
//        },Collectors.mapping(new Function<List<MyEntity>, Long>() {
//            @Override
//            public Long apply(List<MyEntity> myEntities) {
//                return Long.valueOf(myEntities.stream().mapToInt(info -> info.getId()).summaryStatistics().getSum());
//            }
//        }));


        //格式化姓名输出
        String names = Optional.ofNullable(myEntityList).orElse(Collections.emptyList()).stream()
                .map(info -> info.getName()).collect(Collectors.joining(",", "[", "]"));
        System.out.println("\n格式化姓名输出 " + names);

        //格式化姓名输出 stringBuilder.reduce
        System.out.println("\n格式化姓名输出 stringBuilder.reduce");
        StringBuilder stringBuilder = Optional.ofNullable(myEntityList).orElse(Collections.emptyList()).stream()
                .map(MyEntity::getName).reduce(new StringBuilder(), new BiFunction<StringBuilder, String, StringBuilder>() {
                    @Override
                    public StringBuilder apply(StringBuilder stringBuilder, String s) {
                        return stringBuilder.append(s).append(",");
                    }
                }, new BinaryOperator<StringBuilder>() {
                    @Override
                    public StringBuilder apply(StringBuilder stringBuilder, StringBuilder stringBuilder2) {
                        return stringBuilder.append(stringBuilder2);
                    }
                });
        stringBuilder.insert(0,"[");
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());


        //Map computeIfAbsent
        Map<String, Integer> map = new HashMap<>();
        Stream.of(1,1,1).collect(Collectors.toList()).stream().forEach(info->{
            map.putIfAbsent("1", 1);
        });

        //Map forEach
        System.out.println("\nMap forEach 一次循环key value 都得的");
        map.forEach(new BiConsumer<String, Integer>() {
            @Override
            public void accept(String s, Integer integer) {
                System.out.println("key =   " + s + "   value   =" + integer);
            }
        });

    }
}
