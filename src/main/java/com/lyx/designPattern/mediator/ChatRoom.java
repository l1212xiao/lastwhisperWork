package com.lyx.designPattern.mediator;

import java.util.Date;

/**
 * @author lvyunxiao
 * @classname ChatRoom
 * @description ChatRoom
 * @date 2020/5/11
 */
public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() + "] : " + message);
    }
}
