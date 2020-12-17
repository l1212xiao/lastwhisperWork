package com.lyx.everyDayTraining.beforeMeituan.daLuanShuZu;

/*
random.nextInt()的用法

1、不带参数的nextInt()会生成所有有效的整数（包含正数，负数，0）

2、带参的nextInt(int x)则会生成一个范围在0~x（不包含X）内的任意正整数

　　例如：int x=new Random.nextInt(100);

　　　　则x为一个0~99的任意整数

3、生成一个指定范围内的整数
 */

import java.util.Random;

/**
 * @author lvyunxiao
 * @date 2020/9/11
 */
public class RandomDemo {

    /**
     * 生成[min, max]之间的随机整数
     *
     * @param min 最小整数
     * @param max 最大整数
     * @return [min, max]之间的随机整数
     */
    @Deprecated
    private static int randomInt(int min, int max) {
        //return new Random().nextInt(max) % (max - min + 1) + min;
        Random random = new Random();
        int r = random.nextInt(max);
        System.out.println("=== r ===: " + r);
        int len = max - min + 1;
        System.out.println("len: " + len);
        int m = r % len;
        System.out.println("m: " + m);
        int i = m + min;
        System.out.println("i: " + i);
        return i;
    }

    // [min,max)
    private static int randRange(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        // int min = 0;
        // int max = 100;
        // int i = randRange(min, max);
        // System.out.println(i);

        while (true) {
            int anInt = randomInt(10, 20);
            System.out.println("== " + anInt + " ==");
            if (anInt == 20) {
                System.out.println(String.format("get max %d", anInt));
                break;
            }
        }
    }
}
