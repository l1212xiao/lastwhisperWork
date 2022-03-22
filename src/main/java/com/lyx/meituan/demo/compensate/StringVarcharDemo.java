package com.lyx.meituan.demo.compensate;

/**
 * @author lvyunxiao
 * @date 2021/12/21
 * @description
 */
public class StringVarcharDemo {

    public static void main(String[] args) {
        String s = "买赔单号：MP2021122000002012";
        String reasonPre = "买赔单号：MP2021122000002012，驳回原因：";
        String reason1 = "买赔单号：MP2021122000002012，驳回原因：一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十一二三四五六七八九十";

        String realReason = "一二三四五六七八九十";
        String realReasonResult = "一二三四五六七八九十";
        for (int i = 0; i < 22; i++) {
            realReasonResult += realReason;
        }
        System.out.println(realReasonResult);
        System.out.println(reason1.length());
        System.out.println(realReasonResult.length());

        realReasonResult = reasonPre + realReasonResult;
        System.out.println(realReasonResult);
        System.out.println(realReasonResult.length());


    }

}
