package com.lyx.designPattern.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname Broker
 * @description Broker
 * @date 2020/5/9
 */
public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
