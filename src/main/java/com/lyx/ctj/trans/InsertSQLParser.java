package com.lyx.ctj.trans;

import java.util.HashMap;
import java.util.Map;

public class InsertSQLParser {
	public static void main(String[] args) {
		String insertStatement = "INSERT INTO table_name (column1, column2, column3) VALUES (value1, value2, value3);"; // 输入的插入记录的 SQL 语句
		Map<String, String> fieldValueMap = parseInsertStatement(insertStatement);
		System.out.println("Field Value Map: " + fieldValueMap);
	}

	public static Map<String, String> parseInsertStatement(String insertStatement) {
		Map<String, String> fieldValueMap = new HashMap<>();

		// 去除首尾空白字符并删除末尾的分号
		insertStatement = insertStatement.trim().replaceAll(";$", "");

		// 提取字段名和对应的值
		String[] parts = insertStatement.split("\\(\\s*|\\s*\\)|\\s*VALUES\\s*\\(\\s*|\\s*\\)");
		String[] insertTable = parts[0].split("\\s");
		String[] columns = parts[1].split("\\s*,\\s*");
		String[] values = parts[parts.length - 1].split("\\s*,\\s*");

		// 将字段名和对应的值存入 HashMap
		for (int i = 0; i < columns.length; i++) {
			// 如果值为空字符串，则跳过
			if (i < values.length && !values[i].isEmpty()) {
				fieldValueMap.put(columns[i], values[i]);
			}
		}

		// 提取表名
		String tableName = null;
		for (int i = 0; i < insertTable.length; i++) {
			if (insertTable[i].equalsIgnoreCase("INTO")) {
				tableName = insertTable[i + 1];
				break;
			}
		}
		System.out.println(tableName);

		return fieldValueMap;
	}
}

