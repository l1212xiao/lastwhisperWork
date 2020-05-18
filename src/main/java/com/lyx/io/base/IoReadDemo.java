package com.lyx.io.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lvyunxiao
 * @classname IoStreamDemo
 * @description IoStreamDemo
 * @date 2020/5/14
 */
public class IoReadDemo {
    public static void main(String[] args) throws IOException {
        char c;
        // 使用System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("输入字符，按下 'q' 键退出。");
        // 读取字符
        do {
            c = (char) br.read();
            System.out.println(c);
        } while (c != 'q');
    }
}
