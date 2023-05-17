package com.lyx.OwnLearning;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lvyunxiao
 * @date 2023/5/17
 *
 * ref: https://blog.csdn.net/naruto227/article/details/113513852
 */
public class MapDemo {

	public static void main(String[] args) {

		/*
		Map<String, String> map = new HashMap<>();
		// java8之前，从map中根据key获取value操作可能会下面的操作
		String key = map.get("key");
		if (key == null) {
			key = "hh";
			map.put("key", key);
		} else {
			// 如果key对应的value值存在，进行相应的操作
		}

		// java8之后，上面的操作可以简化为一行，若key的value值为空，会将第二个参数的返回值存入并返回
		String val = map.computeIfAbsent("key1", k -> "test");
		System.out.println(map);
		// 打印：{key1=test, key=hh}
		 */


		/*
		Map<String, AtomicInteger> map = new HashMap<>();
		// 统计字段出现个数
		List<String> list = Lists.newArrayList("apple", "orange", "banana", "orange", "banana",
				"orange");
		list.forEach(str -> map.computeIfAbsent(str, k -> new AtomicInteger()).getAndIncrement());
		// 遍历
		map.forEach((k, v) -> System.out.println(k + ": " + v));
		*/

		Map<String, List<String>> map = new HashMap<>();
		// 如果key不存在，则创建新list并放入数据；key存在，则直接往list放入数据
		map.computeIfAbsent("fruit", k -> new ArrayList<>()).add("apple");
		map.computeIfAbsent("fruit", k -> new ArrayList<>()).add("orange");
		map.computeIfAbsent("language", k -> new ArrayList<>()).add("english");
		// 遍历
		map.forEach((k, v) -> System.out.println(k + " " + v));


	}
}
