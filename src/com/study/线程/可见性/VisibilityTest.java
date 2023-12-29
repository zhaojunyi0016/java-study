package com.study.线程.可见性;

/**
 * @Author : Williams
 * Date : 2023/12/29 14:58
 */
public class VisibilityTest {

    private boolean flag = true;
    private volatile int count = 0;

    public void refresh() {
        flag = false;
        System.out.println(Thread.currentThread().getName() + "修改 flag :" + flag);
    }

    public void load() {
        System.out.println(Thread.currentThread().getName() + "开始执行....");
        while (flag) {
            count++;
            // 调用 System.out.println() 可以跳出, 是因为底层使用了 synchronized 关键字, 底层调用了内存屏障
            // volatile 加在 count 上也能跳出, 是因为缓存行
            // Thread.yeild() 能跳出是因为释放时间片，重新加载上下文
            // LockSupport.unpark(Thread.currentThread());  也可以跳出循环 底层调用了内存屏障
            // 或者休眠一下, 让工作内存被淘汰了也能重新读取新的值
            // count 换成 Integer 也能跳出,  因为拆包的时候 new 了一个 int value,  vlaue 是 final 修饰的
        }
        System.out.println("跳出循环 count =" + count);
    }

    public static void main(String[] args) throws InterruptedException {
        VisibilityTest test = new VisibilityTest();
        Thread thread1 = new Thread(() -> test.load(),"ThreadA");
        thread1.start();

        Thread.sleep(10000);
        Thread thread2 = new Thread(() -> test.refresh(),"ThreadB");
        thread2.start();
    }
}
