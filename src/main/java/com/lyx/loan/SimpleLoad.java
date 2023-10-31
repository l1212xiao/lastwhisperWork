package com.lyx.loan;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Period;

/**
 * @author lvyunxiao
 * @date 2023/6/2
 * @description
 */
public class SimpleLoad {

	public static void main(String[] args) {

		// 第一期
		String firstLoadMonth = "2022-10-01";

		// 当前月数，最近需要还款的日期
		String curMonth = "2023-11-01";

		// 最后一期
		// String lastLoadMonth = "2047-09-06";
		String lastLoadMonth = "2047-09-06";

		Period between = Period.between(LocalDate.parse(curMonth), LocalDate.parse(lastLoadMonth));
		System.out.println(String.format("还需还款时间：%d年%d月", between.getYears(), between.getMonths()));

		double monthCount = between.getYears() * 12 + between.getMonths() + 1;
		System.out.println("已还款月数：" + (int) (300 - monthCount));
		System.out.println("总还款月数：" + (int) monthCount);

		// 贷款本金
		// double loanAmountC = 1930000; // 初始贷款金额
		// double loanAmountC = 158_5992.2D; // 当前待还款金额  // 2023-06-02
		// double loanAmountC = 158_3123.03D; // 当前待还款金额  // 2023-07-03
		// double loanAmountC = 157_7349.86D; // 当前待还款金额  // 2023-09-06
		// double loanAmountC = 1_574_404.37D; // 当前待还款金额  // 2023-10-09 每月 9189.17
		// double loanAmountC = 1_374_404.37D; // 当前待还款金额  // 预设
		double loanAmountC = 100_0000.0D; // 目标金额，理想 每月 5836.6

		System.out.println("剩余贷款本金：" + formatAmt(loanAmountC));
		// 月利率
		double yearInterestC = 4.75; // 商业贷款年利率
		// double yearInterestC = 3.10; // 公积金贷款年利率
		double monthlyInterestC = (yearInterestC / 12D) / 100D; // 月利率
		// 还款月数
		// double allMonth = 300; // 初始还款月数
		double allMonth = monthCount; // 当前还款月数

		// 等额本息 : 贷款本金*月利率*(1+月利率)^还款月数/((1+月利率)*还款月数-1)  = 贷款本金*月利率 / 1 - 1/(月利率*(1+月利率)^还款月数)
		double monthlyPaymentC_ECT = loanAmountC * monthlyInterestC / (1 - 1 / Math.pow(1 + monthlyInterestC, allMonth));

		// 总还款金额
		double totalPaymentC_ECT = monthlyPaymentC_ECT * allMonth;

		System.out.println("每月需要还款：" + formatAmt(monthlyPaymentC_ECT));

		System.out.println("共需还款利息：" + formatAmt(totalPaymentC_ECT - loanAmountC));

		System.out.println("总还款金额：" + formatAmt(totalPaymentC_ECT));

	}

	/**
	 * 金额保留两位小数
	 */
	public static String formatAmt(double amt) {
		BigDecimal bd = new BigDecimal(amt);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		return bd.toString();
	}

}
