package com.lyx.meituan.demo.compensate;

import java.math.BigDecimal;

/**
 * @author lvyunxiao
 * @date 2021/11/30
 * @description
 */
public class FillAmountDemo {

    private static final Long DISCOUNT_RATIO = 10_000L;

    // public static void main(String[] args) {
    //     Long detailAmountSum = 20000L;
    //     int discount = 5000;
    //     Long discountAmount;
    //
    //
    //     if (0 == discount) {
    //         discountAmount = 0L;
    //     } else {
    //         final double calVal = (discount * 1.0D / 10_000) * detailAmountSum;
    //         // 四舍五入处理
    //         final long roundVal = Math.round(calVal);
    //         discountAmount = roundVal;
    //     }
    //
    //     System.out.println(discountAmount);
    // }

    public static void main(String[] args) {
        Long detailAmountSum = 20000L;
        int discount = 5000;
        Long discountAmount;


        if (0 == discount) {
            discountAmount = 0L;
        } else {
            final BigDecimal calVal = new BigDecimal(discount).divide(new BigDecimal(DISCOUNT_RATIO))
                .multiply(new BigDecimal(detailAmountSum)).setScale(0, BigDecimal.ROUND_HALF_UP);
            // 四舍五入处理
            final long roundVal = calVal.longValue();
            discountAmount = roundVal;
        }

        System.out.println(discountAmount);
    }

}
