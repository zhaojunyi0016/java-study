package com.study.jvm.逃逸分析;

/**
 * @Author : Williams
 * Date : 2024/1/4 15:02
 */

public class User {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
