package com.study.jvm.逃逸分析;

/**
 * @Author : Williams
 * Date : 2024/1/4 15:02
 */

public class User {
    private Integer id;
    private String name;


    public User() {

    }

    public User(int id, String toString) {
        this.id = id;
        this.name = toString;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 测试 finalize 方法
     * @throws Throwable
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("执行 finalize 方法, 对象回收 userId =" + id);
    }
}
