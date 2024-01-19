package com.study.线程.查看所有线程;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @Author : Williams
 * Date : 2024/1/19 14:51
 */
public class getThread {

    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for ( ThreadInfo t :threadInfos){
            System.out.println(t);
            // 遍历打印所有线程
        }
    }
}
