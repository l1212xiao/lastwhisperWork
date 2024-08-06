package com.lyx.ctj.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

/**
 * @author lvyunxiao
 * @date 2024/5/10
 * @description
 */
public class TestDemo {

	public static void main(String[] args) {

		// String amt = "10000000";
		// String amt = "10,000,000.00";
		//
		// Pattern patternAmt = Pattern.compile("^\\s*(?=.*[1-9])\\d*(?:\\.\\d{1,2})?\\s*$");
		// if (!patternAmt.matcher(amt).matches()) {
		// 	System.out.println("???");
		// }
		int a = 13;
		int b = 99;
		String s = calculatePercentageWithBigDecimal(a, b);
		System.out.println(s);
	}

	public static String calculatePercentageWithBigDecimal(int a, int b) {
		if (b == 0) {
			throw new ArithmeticException("Cannot divide by zero");
		}
		BigDecimal bigA = new BigDecimal(a);
		BigDecimal bigB = new BigDecimal(b);
		BigDecimal result = bigA.multiply(BigDecimal.valueOf(100)).divide(bigB, 2, RoundingMode.HALF_UP);
		return result.toString();
	}

}
