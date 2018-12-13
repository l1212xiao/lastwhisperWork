package com.lyx.OwnLearning.data_structure;

import java.util.StringJoiner;

/**
 * Created on 2018/11/16
 *
 * @author lvyunxiao
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
//        StringJoiner stringJoiner = new StringJoiner(",", "{", "}");
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("a");
        stringJoiner.add("b");
        stringJoiner.add("c");
        System.out.println(stringJoiner.toString());
    }

}
