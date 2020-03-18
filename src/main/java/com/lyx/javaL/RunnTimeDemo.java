package com.lyx.javaL;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Properties;

/**
 * @Classname RunnTimeDemo
 * @Description RunnTimeDemo
 * @Date 2019/10/26
 * @author lvyunxiao
 */
public class RunnTimeDemo {
    public static void main(String[] args) {
        // System.out.println(new Date());
        // Properties p = System.getProperties();
        // p.list(System.out);
        // System.out.println("--- Memory Usage:");
        // Runtime runtime = Runtime.getRuntime();
        // System.out.println("Total Memory = "
        //         + runtime.totalMemory()
        //         + " Free Memory = "
        //         + runtime.freeMemory()
        // );
        LocalDateTime dateTime = LocalDateTime.now().minusDays(1);
        System.out.println("昨天的时间为："+dateTime);
    }
}
