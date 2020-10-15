package com.lyx.zuo.trainingcamp004.class04;

/*
Nim博弈问题
给定一个非负数组，每一个值代表该位置上有几个铜板。
a和b玩游戏，a先手，b后手， 轮到某个人的时候，只能在一个位置上拿任意数量的铜板，
但是不能不拿。谁最先把铜 板拿完谁赢。假设a和b都极度聪明，请返回获胜者的名字
 */


public class Code03_Nim {

	// 保证arr是正数数组
	public static void printWinner(int[] arr) {
		int eor = 0;
		for (int num : arr) {
			eor ^= num;
		}
		if (eor == 0) {
			System.out.println("后手赢");
		} else {
			System.out.println("先手赢");
		}
	}

}
