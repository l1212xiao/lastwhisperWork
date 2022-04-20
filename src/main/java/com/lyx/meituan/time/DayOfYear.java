package com.lyx.meituan.time;

import java.time.LocalDate;

/**
 * @author lvyunxiao
 * @date 2022/4/14
 * @description
 */
public class DayOfYear {

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.getYear() + ":" + localDate.getDayOfYear() + ":" + localDate.getMonth());
    }
}
