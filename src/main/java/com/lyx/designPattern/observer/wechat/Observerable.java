package com.lyx.designPattern.observer.wechat;

/**
 * 抽象被观察者接口
 * 声明了添加、删除、通知观察者方法
 *
 * @author lvyunxiao
 * @date 2022/1/6
 * @description
 */
public interface Observerable {

    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
