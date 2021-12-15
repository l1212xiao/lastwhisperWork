package com.lyx.meituan.demo.compensate;

/**
 * @author lvyunxiao
 * @date 2021/11/30
 * @description
 */
public class FillAmountDemo {

    public static void main(String[] args) {
        Long detailAmountSum = 200000L;
        int discount = 5000;
        Long discountAmount;


        if (0 == discount) {
            discountAmount = 0L;
        } else {
            final double calVal = (discount * 1.0D / 10_000) * detailAmountSum;
            // 四舍五入处理
            final long roundVal = Math.round(calVal);
            discountAmount = roundVal;
        }

        System.out.println(discountAmount);
    }
}
