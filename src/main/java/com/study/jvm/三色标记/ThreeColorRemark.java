package com.study.jvm.三色标记;

/**
 * @Author : Williams
 * Date : 2024/1/22 17:39
 */
public class ThreeColorRemark {
    public static void main(String[] args) {
        A a = new A();
        // 开始做并发标记
        D d = a.b.d; // 1. 读
        a.b.d = null; // 2. 写
        a.d = d;     // 3. 写
    }


    static class A {
        B b = new B();
        D d = null;
    }


    static class B {
        C c = new C();
        D d = new D();
    }


    static class C {

    }


    static class D {

    }
}
