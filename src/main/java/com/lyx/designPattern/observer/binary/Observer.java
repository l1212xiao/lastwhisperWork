package com.lyx.designPattern.observer.binary;

/**
 * @author lvyunxiao
 * @classname Observer
 * @description Observer
 * @date 2020/4/30
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
