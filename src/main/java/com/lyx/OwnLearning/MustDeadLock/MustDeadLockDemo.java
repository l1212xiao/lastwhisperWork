package com.lyx.OwnLearning.MustDeadLock;

import java.util.concurrent.TimeUnit;

/**
 * @author lvyunxiao
 * @date 2021/11/9
 * @description 必然死锁实例
 */
public class MustDeadLockDemo {

    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        new Thread(new DeadLockTask(lock1, lock2, 1), "线程1").start();
        new Thread(new DeadLockTask(lock1, lock2, 2), "线程2").start();
    }

    static class DeadLockTask implements Runnable {

        private Object lock1;

        private Object lock2;

        private Integer task;

        public DeadLockTask(Object lock1, Object lock2, Integer task) {
            this.lock1 = lock1;
            this.lock2 = lock2;
            this.task = task;
        }

        @Override
        public void run() {
            if (1 == task) {
                synchronized (lock1) {
                    System.out.println(Thread.currentThread().getName() + "->拿到锁1");
                    try {
                        // Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "->等到锁2释放");
                    synchronized (lock2) {
                        System.out.println(Thread.currentThread().getName() + "拿到锁2");
                    }
                    System.out.println("任务" + task + "结束");
                }

            }

            if (2 == task) {
                synchronized (lock2) {
                    System.out.println(Thread.currentThread().getName() + "->拿到锁2");
                    try {
                        // Thread.sleep(1000);
                        TimeUnit.SECONDS.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "->等到锁2释放");
                    synchronized (lock1) {
                        System.out.println(Thread.currentThread().getName() + "拿到锁1");
                    }
                    System.out.println("任务" + task + "结束");
                }
            }

        }
    }


}
