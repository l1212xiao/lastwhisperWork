package com.lyx.io.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lvyunxiao
 * @classname IoReadLineDemo
 * @description IoReadLineDemo
 * @date 2020/5/14
 */
public class IoReadLineDemo {
    public static void main(String[] args) throws IOException {
        String str;
        // 使用System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter lines of text.");
        System.out.println("Enter 'end' to quit.");
        // 读取字符
        do {
            str = br.readLine();
            System.out.println(str);
        } while (!str.equals("end"));
    }
}
