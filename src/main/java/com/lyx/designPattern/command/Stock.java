package com.lyx.designPattern.command;

/**
 * @author lvyunxiao
 * @classname Stock
 * @description Stock
 * @date 2020/5/9
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }

    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}
