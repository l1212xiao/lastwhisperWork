package com.lyx.zuo.trainingcamp004.class04;

/*
给定一个数组arr，长度为N且每个值都是正数，代表N个人的体重。再给定一个正数 limit，代表一艘船的载重。
以下是坐船规则，
1)每艘船最多只能做两人;
2)乘客 的体重和不能超过limit
返回如果同时让这N个人过河最少需要几条船。
 */


public class Code05_MinBoat {

	// 请保证arr有序
	public static int minBoat(int[] arr, int limit) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		// Arrays.sort(arr);
		if(arr[N - 1] > limit) {
			return -1;
		}
		int lessR = -1;
		// 所有的人体重都不超过limit，继续讨论,  <= limit / 2  最右的位置
		for (int i = N  - 1; i >= 0; i--) {
			if (arr[i] <= (limit / 2)) {
				lessR = i;
				break;
			}
		}
		if (lessR == -1) {
			return N;
		}
		//  <= limit / 2
		int L = lessR;
		int R = lessR + 1;
		int noUsed = 0; // 画X的数量统计，画对号的量(加工出来的)
		while (L >= 0) {
			int solved = 0; // 此时的[L]，让R画过了几个数
			while (R < N && arr[L] + arr[R] <= limit) {
				R++;
				solved++;
			}
			// R来到又不达标的位置
			if (solved == 0) {
				noUsed++;
				L--;
			} else { // 此时的[L]，让R画过了solved（>0）个数
				L = Math.max(-1, L - solved);
			}
		}
		int all = lessR + 1;// 左半区总个数  <= limit /2 的区域
		int used = all - noUsed; // 画对号的量
		int moreUnsolved = (N - all) - used; // > limit/2 区中，没搞定的数量
		return used + ((noUsed + 1) >> 1) + moreUnsolved;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 5 };
		int weight = 6;
		System.out.println(minBoat(arr, weight));
	}

}
