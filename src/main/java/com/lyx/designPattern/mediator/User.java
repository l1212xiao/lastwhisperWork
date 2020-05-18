package com.lyx.designPattern.mediator;

/**
 * @author lvyunxiao
 * @classname User
 * @description User
 * @date 2020/5/11
 */
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name){
        this.name  = name;
    }

    public void sendMessage(String message){
        ChatRoom.showMessage(this,message);
    }
}
