package com.lyx.OwnLearning.others.andOrNot;

/**
 * @Classname AndOrNotDemo
 * @Description AndOrNotDemo
 * @Date 2019/8/27
 * @auther lvyunxiao
 * <p>
 * Java的位运算符详解实例——与（&）、非（~）、或（|）、异或（^）
 * https://blog.csdn.net/vebasan/article/details/6193916
 */
public class AndOrNotDemo {
    public static void main(String[] args) {
        int a = 2;
        a &= 3;
        System.out.println(a);

        int a1 = 4;
        int b1 = 2;
        a1 |= b1;
        System.out.println(a1);

        int a2 = 128; //10000000
        int b2 = 129;
        int c3 = 3;
        //String s = Long.toBinaryString(-128);
        //System.out.println(a2 &= b2);
        //System.out.println(~c3);
        //System.out.println(s);
        //System.out.println(s.length());

        int a3 = 4;
        int b3 = 2;
        System.out.println(a3 ^= b3);

        int a4 = 4;
        int b4 = 2;
        System.out.println(a4 >>= b4);




    }
}
