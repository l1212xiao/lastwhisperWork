package com.lyx.OwnLearning.interview;

/**
 * @author lvyunxiao
 * @date 2022/3/2
 * @description
 */
public class ThreadJoinTest {

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(() -> System.out.println("T1"));
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T2");
        });
        Thread t3 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("T3");
        });
        t1.start();
        t3.start();
        t2.start();
    }

}
