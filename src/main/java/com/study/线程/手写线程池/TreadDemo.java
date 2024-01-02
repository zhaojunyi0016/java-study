package com.study.线程.手写线程池;

import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TreadDemo extends Thread {

    //声明一个阻塞队列容器， 用来存储任务集合
    private static BlockingQueue queue = new ArrayBlockingQueue(100);

    static {
        new TreadDemo().start();
    }

    /**
     * 消费者，不断自选的去获取 任务队列的元素，并且执行，
     * 防止无任务时候的空转，使用阻塞队列使其阻塞
     */
    @Override
    public void run() {
        while (true) {
            try {
                //获取阻塞队列任务， 消费数据
                Object take = queue.take();
                System.out.println(Thread.currentThread().getName() + "消费数据 =  " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * main线程作为一个生产者 往阻塞队列添加元素
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入要执行的任务");
            while (true) {
                String s = scanner.nextLine();
                if (s.contains(",")) {
                    String[] split = s.split(",");//模拟同事传入多个任务
                    for (String string : split) {
                        queue.add(string);
                    }
                } else {
                    queue.put(s); //只输入一个任务
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
