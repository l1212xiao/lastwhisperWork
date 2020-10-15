package com.lyx.zuo.algorithmbasic2020.class11;

/**
 * 范围_上尝试的模型
 * 给定一个整型数组arr,代表数值不同的纸牌排成一条线,
 * 玩家A和玩家B依次拿走每张纸牌,
 * 规定玩家A先拿，玩家B后拿,
 * 但是每个玩家每次只能拿走最左或最右的纸牌,
 * 玩家A和玩家B都绝顶聪明。请返回最后获胜者的分数。
 */
public class Code08_CardsInLine {

	public static int win1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		return Math.max(
				f(arr, 0, arr.length - 1),
				s(arr, 0, arr.length - 1)
				);
	}

	// 先手过程 first
	// L....R
	// F  S  L+1..R
	         // L..R-1
	public static int f(int[] arr, int L, int R) {
		if (L == R) {
			return arr[L];
		}
		
		return Math.max(
				arr[L] + s(arr, L + 1, R),
				arr[R] + s(arr, L, R - 1)
				);
	}

	// 后手拿 second
	// arr[L..R]
	public static int s(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		return Math.min(
				f(arr, L + 1, R), // arr[i]
				f(arr, L, R - 1)  // arr[j]
				);
	}

	public static int win2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int N = arr.length;
		int[][] f = new int[N][N];
		int[][] s = new int[N][N];
		for(int i = 0; i < N;i++) {
			f[i][i] = arr[i];
		}
		// s[i][i] = 0;
		for(int i = 1; i < N;i++) {
			int L =0;
			int R =i;
			while(L < N && R < N) {
				
				f[L][R] = Math.max(
						arr[L] + s[L + 1][ R],
						arr[R] + s[L][R - 1]
						); 
				s[L][R] = Math.min(
						f[L + 1][R], // arr[i]
						f[L][R - 1]  // arr[j]
						); 
				
				L++;
				R++;
				
			}
		}
		return Math.max(f[0][N-1], s[0][N-1]);
	}

	public static void main(String[] args) {
		int[] arr = { 4,7,9,5,19,29,80,4 };
		// A 4 9
		// B 7 5
		System.out.println(win1(arr));
		System.out.println(win2(arr));

	}

}
