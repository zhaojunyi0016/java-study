package com.study.jvm.java_基本类型传递;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        function(a);
        System.out.println(a);
    }

    public static void function(int a) {
        int b = 10;
        System.out.println(b + a);
        a = 11;
    }
}