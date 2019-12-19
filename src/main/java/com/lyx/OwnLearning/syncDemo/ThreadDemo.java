package com.lyx.OwnLearning.syncDemo;

/**
 * @author lvyunxiao
 * @classname ThreadDemo
 * @description ThreadDemo
 * @date 2019/12/11
 * ref:https://blog.csdn.net/qq_35249342/article/details/91447181
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //场景模拟:创建三个线程模拟三个售票窗口,来同时出售一百张票
        MyTicket ticket = new MyTicket();
        new Thread(ticket, "一号窗口").start();
        new Thread(ticket, "二号窗口").start();
        new Thread(ticket, "三号窗口").start();
    }
}

class MyTicket implements Runnable {
    // 一百张票
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "售票完成,余票 : " + --ticket);
            }
        }
    }
}
