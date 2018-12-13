package com.lyx.OwnLearning.own;

/**
 * Created by lyx on 2018/6/22.
 */
public class PiDemo {
    public static void main(String[] args) {

        double x;
        double y;

        double count = 0;
        int n = 10000000;
        for (int i = 0; i < n; i++) {
            x = Math.random() * 2 - 1;
            y = Math.random() * 2 - 1;

            if (x * x + y * y <= 1) {
                count++;
            }
        }

        //面积法 Pi*1 / 4 = count / n
        double Pi = count / n * 4;
        System.out.println("Pi为：" + Pi);

    }
}
