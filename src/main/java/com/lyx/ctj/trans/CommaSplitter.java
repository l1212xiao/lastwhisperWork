package com.lyx.ctj.trans;

import java.util.ArrayList;
import java.util.List;

public class CommaSplitter {
	public static void main(String[] args) {
		// String input = "1,'2,2','3',null,to_date(1,2),6"; // 输入的字符串
		String input = "1609681789315,'资金性质-转移支出功能科目','quota',25809,'&mofdivcode',0,to_date('2010-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'),to_date('2021-12-31 00:00:00','yyyy-mm-dd hh24:mi:ss'),'211402811','quota','211402811','FundType','无','无','TpFunc','无','无','&年度','&mofdivcode',to_date('2010-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'),2,1,to_date('2010-01-01 00:00:00','yyyy-mm-dd hh24:mi:ss'),'211402811',1"; // 输入的字符串
		List<String> parts = splitByComma(input);
		System.out.println("切分结果: " + parts);
	}

	public static List<String> splitByComma(String input) {
		List<String> parts = new ArrayList<>();
		StringBuilder sb = new StringBuilder();
		boolean inQuotes = false;
		int parenthesesCount = 0;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '\'') {
				inQuotes = !inQuotes;
			} else if (c == '(' && !inQuotes) {
				parenthesesCount++;
			} else if (c == ')' && !inQuotes) {
				parenthesesCount--;
			}

			if (c == ',' && !inQuotes && parenthesesCount == 0) {
				parts.add(sb.toString());
				sb.setLength(0); // 清空 StringBuilder
			} else {
				sb.append(c);
			}
		}
		parts.add(sb.toString()); // 添加最后一个部分

		return parts;
	}
}
