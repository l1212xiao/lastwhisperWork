package com.lyx.OwnLearning.basicLearning;

/**
 * @author lvyunxiao
 * @date 2022/3/4
 * @description
 */
public class BasicDemo {

    int count = 0;
    public int goodNodesTT() {
        dfsTT();
        return count;
    }

    private void dfsTT() {
        count++;
    }

    public static void main(String[] args) {
        BasicDemo s = new BasicDemo();
        int goodNodesTT = s.goodNodesTT();
        System.out.println(goodNodesTT);
    }
}
