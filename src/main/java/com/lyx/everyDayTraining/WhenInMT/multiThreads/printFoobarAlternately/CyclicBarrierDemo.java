package com.lyx.everyDayTraining.WhenInMT.multiThreads.printFoobarAlternately;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author lvyunxiao
 * @date 2021/9/7
 * @description ref: https://www.jianshu.com/p/333fd8faa56e
 */
public class CyclicBarrierDemo {

    static class TaskThread extends Thread {

        CyclicBarrier barrier;

        public TaskThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt( 1000) + 1000);
                System.out.println(getName() + " 到达栅栏 A");
                barrier.await();
                System.out.println(getName() + " 冲破栅栏 A");

                // Thread.sleep(2000);
                // System.out.println(getName() + " 到达栅栏 B");
                // barrier.await();
                // System.out.println(getName() + " 冲破栅栏 B");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        int threadNum = 5;
        CyclicBarrier barrier = new CyclicBarrier(threadNum,
            () -> System.out.println(Thread.currentThread().getName() + " 完成最后任务"));

        for(int i = 0; i < threadNum; i++) {
            new TaskThread(barrier).start();
        }
    }

    // 从打印结果可以看出，所有线程会等待全部线程到达栅栏之后才会继续执行，并且最后到达的线程会完成 Runnable 的任务。

}
