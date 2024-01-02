package com.study.线程.策略模式_线程池;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * 顶级模板类
 */
public abstract class AbstractCalculate implements Callable {

    //结果集, 用来存储每个任务跑完的结果
    List<Integer> result  = new ArrayList<>();

    /**
     * 计算方法, 有新的分类,只要创建一个类,并且继承AbstractCalculate,并且覆写该方法实现具体逻辑即可
     */
    abstract void calculate();

    @Override
    public Object call() throws Exception {
        calculate();
        return result;
    }
}
