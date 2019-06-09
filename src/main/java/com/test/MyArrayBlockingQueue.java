package com.test;

import java.util.concurrent.ArrayBlockingQueue;

public class MyArrayBlockingQueue {
    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(3);
        /**
     * 新增                           add                                                     offer                                                                put
     * 说明                           在尾部添加，添加成功返回true,队列满则抛出异常           在尾部添加，添加成功返回ture, 队列满则返回false                     在尾部添加，添加成功返回ture, 队列满则等待
         *
         *
         *
         * 
     * 删除                           remove()  或者 remove(Object o)                           poll  或者 public E poll(long timeout,TimeUnit unit)               take
     * 说明                           获取值返回，NoSuchElementException                        从头取数据并且移除该数据，如果队列为空则返回null                   从头取数据并删除，如果没数据就等待
         */
        queue.add(1);
        boolean f   = queue.remove(1);
        System.out.println(f);
        f   = queue.remove(1);
        System.out.println(f);


    }
}
