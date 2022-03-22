package com.lyx.everyDayTraining.WhenInMT.complexNumberMultiplication;

/*
537. 复数乘法

复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：

    实部 是一个整数，取值范围是 [-100, 100]
    虚部 也是一个整数，取值范围是 [-100, 100]
    i2 == -1

给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。

示例 1：

输入：num1 = "1+1i", num2 = "1+1i"
输出："0+2i"
解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。

示例 2：

输入：num1 = "1+-1i", num2 = "1+-1i"
输出："0+-2i"
解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。

提示：
    num1 和 num2 都是有效的复数表示。

 */


/**
 * @author lvyunxiao
 * @date 2022/2/25
 * @description
 */
public class Solution {

    public String complexNumberMultiply(String num1, String num2) {
        int[] comNum1 = getComNum(num1);
        int[] comNum2 = getComNum(num2);

        int res1 = comNum1[0] * comNum2[0] + (comNum1[1] * comNum2[1] * -1);
        int res2 = comNum1[1] * comNum2[0] + comNum1[0] * comNum2[1];
        StringBuilder resBuilder = new StringBuilder();
        resBuilder.append(res1).append("+").append(res2).append("i");
        return resBuilder.toString();
    }

    private int[] getComNum(String num) {
        String[] split = num.split("\\+|i");
        int[] res = new int[2];
        res[0] = Integer.parseInt(split[0]);
        res[1] = Integer.parseInt(split[1]);
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String num1 = "1+1i", num2 = "1+1i";
        String num1 = "1+-1i", num2 = "1+-1i";
        String complexNumberMultiply = s.complexNumberMultiply(num1, num2);
        System.out.println(complexNumberMultiply);
    }
}
