package com.lyx.OwnLearning.OptionDemo;

/**
 * @author lvyunxiao
 * @date 2021/10/22
 * @description
 */
public class TestStatus {

    public static void main(String[] args) {
        final String nameByCode = InventoryProcessOrderStatus.getNameByCode(1234);
        System.out.println(nameByCode);
    }

}
