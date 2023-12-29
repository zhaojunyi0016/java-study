package com.study.线程.伪共享问题;

import sun.misc.Contended;

/**
 * @Author : Williams
 * Date : 2023/12/29 17:01
 */
public class falseSharingTest {

    static class Pointer {
        //@Contended
        volatile long x; // 8 字节
        volatile long y; // 8 字节  x 和 y 会公用一个缓存行
    }

    public static void main(String[] args) throws InterruptedException {
        testPointer(new Pointer());
    }

    private static void testPointer(Pointer pointer) throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                pointer.x++;
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000000; i++) {
                pointer.y++;
            }
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(pointer.x + "," + pointer.y);
        // 加了 volatile 性能下降非常明显
        System.out.println(System.currentTimeMillis() - start);
    }

}
