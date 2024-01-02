package com.study.jvm.乱序执行;

/**
 * @Author : Williams
 * Date : 2022/12/21 16:21
 */
public class Demo {
    private static int x = 0, y = 0;
    private static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;
            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    //由于线程one 先启动, 下面这句话让它等一等线程 two,
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                @Override
                public void run() {
                    a = 1;
                    y = a;
                }
            });

            one.start();
            other.start();
            one.join();
            other.join();
            String result = "第" + i + "次(" + x + "," + y + ")";
            if (x == 0 && y == 0) {
                System.out.println(result);
                break;
            }
        }

    }


}
