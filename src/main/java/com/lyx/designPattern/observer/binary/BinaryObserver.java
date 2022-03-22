package com.lyx.designPattern.observer.binary;

/**
 * @author lvyunxiao
 * @classname BinaryObserver
 * @description BinaryObserver
 * @date 2020/4/30
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}
