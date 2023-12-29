package com.study.反射;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author : Williams
 * Date : 2022/12/21 19:56
 */
public class Reflect {

    public static void main(String[] args) throws Exception {
        Person p = new Person();
        p.age = 12;
        test(p);

    }

    public static void test(Object object) throws Exception {
        //获取对象的 class 类型
        Class<?> cls = object.getClass();
        //获取到字段
        Field field = cls.getDeclaredField("age");
        System.out.println(field.getInt(object));

        //获取到方法 ,如果是 private 修饰的,
        Method method = cls.getDeclaredMethod("sayHello");
        method.setAccessible(true);//设置程 true 可以访问 private
        method.invoke(object); //执行方法
    }


}

class Person {
    int age;

    public void sayHello() {
        System.out.println("person hellow");
    }
}