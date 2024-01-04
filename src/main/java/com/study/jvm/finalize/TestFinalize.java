package com.study.jvm.finalize;

import com.study.jvm.逃逸分析.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 测试 finalize
 *
 * @Author : Williams
 * Date : 2024/1/4 16:14
 */
public class TestFinalize {

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}
