package com.lyx.meituan.ArraysDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2021/3/27
 * @description
 */
public class ArraysSubListDemo {

    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("遥远的救世主");
        bookList.add("背叛");
        bookList.add("天幕红尘");
        bookList.add("人生");
        bookList.add("平凡的世界");

        List<String> luyaoBookList = bookList.subList(3, 5);// subList返回的是bookList中索引从fromIndex（包含）到toIndex（不包含）的元素集合。

        System.out.println(bookList);
        System.out.println(luyaoBookList);

        // // 修改原集合的值
        // bookList.set(3,"路遥-人生");
        //
        // System.out.println(bookList);
        // System.out.println(luyaoBookList); // 只是修改了原集合bookList的值，但是影响到了子集合luyaoBookList。

        // 修改子集合的值
        luyaoBookList.set(1, "路遥-平凡的世界");

        System.out.println(bookList); // 只是修改了子集合luyaoBookList的值，但是影响到了原集合bookList。
        System.out.println(luyaoBookList);

        // // 往原集合中添加元素
        // bookList.add("早晨从中午开始"); // java.util.ConcurrentModificationException
        //
        // System.out.println(bookList);
        // System.out.println(luyaoBookList);

        // ArrayList的subList方法，返回的是原集合的一个子集合（视图），非结构性修改任意一个集合的元素的值，都会彼此影响，结构性修改原集合时，
        // 会报ConcurrentModificationException异常，结构性修改子集合时，会影响原集合，所以使用时要注意，避免程序错误或者异常。
    }
}
