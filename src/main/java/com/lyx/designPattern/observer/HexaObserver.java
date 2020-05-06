package com.lyx.designPattern.observer;

/**
 * @author lvyunxiao
 * @classname HexaObserver
 * @description HexaObserver
 * @date 2020/4/30
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
