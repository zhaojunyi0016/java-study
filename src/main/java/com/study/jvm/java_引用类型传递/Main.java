package com.study.jvm.java_引用类型传递;

public class Main {
    public static void main(String[] args) {
        int a = 10;
        Person p = new Person(); //main 栈中生成一个 p 引用, 指向一个堆中的地址
        function(p, a);

        //仍然能输出 id 和 name 在 function 函数中修改后的值
        System.out.println("id = " + p.id);
        System.out.println("name =" + p.name);
        System.out.println(a);
    }

    public static void function(Person p, int a) {
        //修改了堆中对象的属性值
        p.id = 1;
        p.name = "zhaojunyi";

        a = 100;
        // 栈 function 出栈, p 引用消失了,  但是堆中的数据并没有消失,需要 gc 去回收后才是垃圾

    }

    static class Person {
        int id;
        String name;
    }
}