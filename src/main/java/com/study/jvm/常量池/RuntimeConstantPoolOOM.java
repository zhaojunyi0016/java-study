package com.study.jvm.常量池;

import java.util.ArrayList;

/**
 /**
 * jdk6：‐Xms6M ‐Xmx6M ‐XX:PermSize=6M ‐XX:MaxPermSize=6M
 * jdk8：‐Xms6M ‐Xmx6M ‐XX:MetaspaceSize=6M ‐XX:MaxMetaspaceSize=6M
 * @Author : Williams
 * Date : 2024/1/27 15:54
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000000; i++) {
            String str = String.valueOf(i).intern();
            list.add(str);
        }
    }
    //运行结果：
    //16 jdk7及以上：Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //17 jdk6：Exception in thread "main" java.lang.OutOfMemoryError: PermGen space
}
