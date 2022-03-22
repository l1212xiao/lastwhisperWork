package com.lyx.designPattern.observer.wechat;

/**
 * [观察者模式]测试类
 *
 * @author lvyunxiao
 * @date 2022/1/6
 * @description ref:https://www.cnblogs.com/porotin/p/7825656.html
 */
public class Test {

    public static void main(String[] args) {
        WechatServer server = new WechatServer();

        Observer userZhang = new User("ZhangSan");
        Observer userLi = new User("LiSi");
        Observer userWang = new User("WangWu");

        server.registerObserver(userZhang);
        server.registerObserver(userLi);
        server.registerObserver(userWang);
        server.setInformation("PHP是世界上最好用的语言！");

        System.out.println("----------------------------------------------");
        server.removeObserver(userZhang);
        server.setInformation("JAVA是世界上最好用的语言！");

    }
}
