package com.lyx.designPattern.command;

/**
 * @author lvyunxiao
 * @classname SellStock
 * @description SellStock
 * @date 2020/5/9
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
