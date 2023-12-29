package com.study.线程.多线程循环打印ABAB;

/**
 * @Author : Williams
 * Date : 2023/3/30 18:17
 */
public class Demo {

    public static void main(String[] args) {
        Object lock = new Object();

        Thread thread1= new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println("A");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                synchronized (lock) {
                    System.out.println("B");
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();


    }
}
