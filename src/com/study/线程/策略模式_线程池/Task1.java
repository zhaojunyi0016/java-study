package com.study.线程.策略模式_线程池;

public class Task1 extends AbstractCalculate{

    @Override
    void calculate() {
        //执行业务代码, 将结果组装到 result集合之中
        result.add(1);
    }
}
