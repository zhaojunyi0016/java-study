package com.study.jvm.逃逸分析;

/**
 * @Author : Williams
 * Date : 2022/12/20 17:52
 */
public class Main {
    public static void main(String[] args) {
        //-Xmx10m -Xms10m -XX:+PrintGC -XX:-DoEscapeAnalysis
        while (true) {
            Integer integer = new Integer(1111111111);
        }
        //关闭逃逸分析后会频繁发生 full gc
    }
}
