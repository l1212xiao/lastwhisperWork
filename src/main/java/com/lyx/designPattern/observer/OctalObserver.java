package com.lyx.designPattern.observer;

/**
 * @author lvyunxiao
 * @classname OctalObserver
 * @description OctalObserver
 * @date 2020/4/30
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: "
                + Integer.toOctalString(subject.getState()));
    }
}
