package com.lyx.OwnLearning.syncDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvyunxiao
 * @classname ThreadDemo
 * @description ThreadDemo
 * @date 2019/12/11
 * ref:https://blog.csdn.net/qq_35249342/article/details/91447181
 */
public class ThreadDemo3 {
    public static void main(String[] args) {
        //场景模拟:创建三个线程模拟三个售票窗口,来同时出售一百张票
        MyTicket3 ticket3 = new MyTicket3();
        new Thread(ticket3, "一号窗口").start();
        new Thread(ticket3, "二号窗口").start();
        new Thread(ticket3, "三号窗口").start();
    }
}

class MyTicket3 implements Runnable {
    //方法三 : Lock同步锁
    private Lock lock = new ReentrantLock();

    // 一百张票
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "售票完成,余票 : " + --ticket);
                }
            }finally {
                //注意:lock 一定要在finally代码块里解锁.
                lock.unlock();
            }
        }
    }
}
