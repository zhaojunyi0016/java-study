package com.study.jvm.逃逸分析;

/**
 * @Author : Williams
 * Date : 2022/12/20 17:52
 */
public class Main {
    public static void main(String[] args) {
        //-Xmx10m -Xms10m -XX:+PrintGC -XX:-DoEscapeAnalysis  会频繁 GC
        //-Xmx10m -Xms10m -XX:+PrintGC -XX:+DoEscapeAnalysis  不会 GC
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            allo();
        }
        long end = System.currentTimeMillis();
        System.out.println("消耗时间:"+ (end - start));
    }

    private static void allo() {
        User user = new User();
        user.setId(1);
        user.setName("zjy");
    }


}
