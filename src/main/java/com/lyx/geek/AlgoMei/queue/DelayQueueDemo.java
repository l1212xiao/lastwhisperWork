package com.lyx.geek.AlgoMei.queue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author lvyunxiao
 * @date 2021/8/31
 * @description ref:https://mp.weixin.qq.com/s/I-zj54OmmRkFf8rykyVDmA
 */
public class DelayQueueDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> list = new ArrayList<>();
        list.add("00000001");
        list.add("00000002");
        list.add("00000003");
        list.add("00000004");
        list.add("00000005");
        DelayQueue<OrderDelay> queue = new DelayQueue<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 5; i++) {
            //延迟三秒取出
            queue.put(new OrderDelay(list.get(i),
                TimeUnit.NANOSECONDS.convert(3, TimeUnit.SECONDS)));
            try {
                queue.take().print();
                System.out.println("After " +
                    (System.currentTimeMillis() - start) + " MilliSeconds");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
