package com.lyx.designPattern.command;

/**
 * @author lvyunxiao
 * @classname BuyStock
 * @description BuyStock
 * @date 2020/5/9
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
