package com.test;

import java.util.*;
import java.util.concurrent.*;
//多线程并发处理，返回结果
public class ManyThreadProcessAndGetResult {
    static ExecutorService executorService =  Executors.newFixedThreadPool(10);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Future> list = new ArrayList<>();
        CopyOnWriteArrayList <Integer> listInteger = new CopyOnWriteArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            final int ii = i;
            Future<Integer> objectFuture = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws InterruptedException {
                    Random random = new Random();
                    Integer temp = random.nextInt(2000) * ii;
                    listInteger.add(temp);
                    Thread.sleep(temp);
                    return temp;
                }
            });
            list.add(objectFuture);
        }

        List<Integer> listIntegerNew = new ArrayList<>();
        Iterator<Future> it = list.iterator();
        while (true) {
            while (it.hasNext()) {
                Future<Integer> x = it.next();
                if (x.isDone()) {
                    listIntegerNew.add(x.get());
                    it.remove();
                }
            }
            it = list.iterator();
            if (!it.hasNext()) {
                break;
            }
        }

        listInteger.sort(Comparator.naturalOrder());
        System.out.println(listInteger);


        listIntegerNew.sort(Comparator.naturalOrder());
        System.out.println(listIntegerNew);
    }
}
