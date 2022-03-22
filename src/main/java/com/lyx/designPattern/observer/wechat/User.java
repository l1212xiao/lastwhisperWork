package com.lyx.designPattern.observer.wechat;

/**
 * 观察者
 * 实现了update方法
 *
 * @author lvyunxiao
 * @date 2022/1/6
 * @description
 */
public class User implements Observer {

    private String name;
    private String message;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        this.message = message;
        read();
    }

    public void read() {
        System.out.println(name + " 收到推送消息： " + message);
    }

}
