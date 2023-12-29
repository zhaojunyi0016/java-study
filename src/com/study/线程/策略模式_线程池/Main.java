package com.study.线程.策略模式_线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //返回结果集
        List<Integer> result = new ArrayList<>();

        //future集合,用来存储异步线程返回的结果
        List<Future> futureList = new ArrayList<>();

        //创建线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(8,
                0,
                0,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(100)
        );

        try {
            //如果有一个分类要计算,就把这个分类提交到线程池去执行
            futureList.add(pool.submit(new Task1()));

            //遍历future结果结合, 组装到
            for (Future object : futureList){
                Object o = object.get();
                System.out.println(o);
                result.add(Integer.valueOf(o.toString()));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //关闭线程池
            pool.shutdownNow();
        }
        System.out.println(result);
    }
}