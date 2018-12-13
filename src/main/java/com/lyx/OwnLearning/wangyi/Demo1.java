package com.lyx.OwnLearning.wangyi;

/**
 * Created by lyx on 2018/8/11.
 */
import java.util.Scanner;
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}