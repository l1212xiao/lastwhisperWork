package com.lyx.OwnLearning.others.outerForDemo;

/**
 * Created on 2018/11/27
 *
 * @author lvyunxiao
 */
public class OuterForDemo {
    public static void main(String[] args) {
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println("i:" + i + " j:" + j);
                if (j == 1) {
                    continue outer;
                }
                if (i == 1) {
                    break outer;
                }
            }
            System.out.println("i: "+i);
        }
    }
}
