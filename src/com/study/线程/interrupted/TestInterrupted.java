package com.study.线程.interrupted;


/**
 * interrupted 方法
 */
public class TestInterrupted extends Thread {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 该线程在处理任务前检查中断状态
                    while (!Thread.interrupted()) {
                        System.out.println("线程执行中...");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    // 如果抛出了 InterruptedException，则会将中断状态置为 true
                    System.out.println("线程被中断了！");
                } finally {
                    // 确保线程的中断状态被清除，这里可以不写
                    Thread.interrupted();
                }
            }
        });
        t.start();

        // 在主线程中调用 t.interrupt() 方法中断线程 t
        try {
            Thread.sleep(5000); // 让 t 线程运行 5 秒钟
            t.interrupt(); // 中断线程 t
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
