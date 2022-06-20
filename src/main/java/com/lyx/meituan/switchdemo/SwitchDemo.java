package com.lyx.meituan.switchdemo;

/**
 * @author lvyunxiao
 * @date 2022/5/17
 * @description
 */
public class SwitchDemo {

    public static void main(String[] args) {
        int num = 2;
        switch (num) {
            case 1:
                ++num;
            case 2:
                ++num;
            case 3:
                ++num;
            default:
                ++num;
            break;
        }
        System.out.println(num); // 5, 没有break的话，会穿透
    }

}
