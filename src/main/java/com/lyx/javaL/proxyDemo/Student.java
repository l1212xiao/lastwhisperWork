package com.lyx.javaL.proxyDemo;

/**
 * @author lvyunxiao
 * @classname Student
 * @description Student
 * @date 2020/3/5
 */
public class Student implements Person {

    private String mName;

    public Student(String name) {
        mName = name;
    }

    @Override
    public void setName(String name) {
        mName = name;
    }
}
