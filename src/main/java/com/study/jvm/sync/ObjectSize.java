package com.study.jvm.sync;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Author : Williams
 * Date : 2024/1/2 17:49
 */
public class ObjectSize {
    public static void main(String[] args) {
        Object c= new Object();
        // 打印对象的信息
        System.out.println(ClassLayout.parseInstance(c).toPrintable());
    }
}
