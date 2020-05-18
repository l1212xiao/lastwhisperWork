package com.lyx.OwnLearning.plusplus;

/**
 * @author lvyunxiao
 * @classname PlusDemo
 * @description PlusDemo
 * @date 2020/5/14
 *
 * 正确答案是
 * i:10
 * j:10
 * n:0
 * m:9
 * 原因
 * i 一般是眼误，以为只存在于循环内，实际上它是定义在循环外的，所以值会一直被保存下来。
 * j 没什么好说的。
 * j++是先赋值，再加加，所以 m 比 j 慢一拍。
 * 同样的道理，n每次赋值给自己都是原始值，它的加加也就显得没有意义。
 * = i++ 这一过程的伪代码类似于
 *  public void ipp(){
 *        int i_temp = i;
 *        i+1;
 *        return i_temp;//返回的是原始值
 *  }
 * ————————————————
 * 版权声明：本文为CSDN博主「New俊」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/ljfirst/article/details/106082534
 */
public class PlusDemo {
    public static void main(String[] args) {
        int j = 0;
        int i = 0;
        int m = 0;
        int n = 0;
        for (; i < 10; i++) {
            m = j++;
            n = n++;
        }
        System.out.println("i:" + i); // i:10
        System.out.println("j:" + i); // j:10
        System.out.println("n:" + n); // n:0
        System.out.println("m:" + m); // m:9
    }
}
