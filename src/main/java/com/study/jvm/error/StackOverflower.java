package com.study.jvm.error;

/**
 * @Author : Williams
 * Date : 2024/1/4 10:46
 */
public class StackOverflower {
    public static void main(String[] args) {
        redo();
    }

    public static void redo(){
        int i =1;
        int i2 =1;
        int i22 =1;
        redo();
    }
}
