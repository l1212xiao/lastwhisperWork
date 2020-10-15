package com.lyx.zuo.trainingcamp003.class01;
/*
有一些排成一行的正方形。每个正方形已经被染成红色或者绿色。现在可以选择任意一个正方形然后用这两种颜色的任意一种进行染色,这个正方形的颜色将 会被覆盖。目标是在完成染色之后,每个红色R都比每个绿色G距离最左侧近。 返回最少需要涂染几个正方形。
如样例所示: s = RGRGR 我们涂染之后变成RRRGG满足要求了,涂染的个数为2,没有比这个更好的涂染方案。
 */
public class Code04_ColorLeftRight {

	// RGRGR -> RRRGG
	public static int minPaint(String s) {
		if (s == null || s.length() < 2) {
			return 0;
		}
		char[] str = s.toCharArray();
		int N = str.length;
		int rAll = 0;	// rALl表示右边的R
		for (int i = 0; i < N; i++) {
			rAll += str[i] == 'R' ? 1 : 0;
		}
		int ans = rAll; // 如果数组所有的范围，都是右侧范围，都变成G
		int left = 0;	// left表示左边的G
		for (int i = 0; i < N - 1; i++) { // 0..i 左侧 n-1..N-1
			left += str[i] == 'G' ? 1 : 0;
			rAll -= str[i] == 'R' ? 1 : 0;
			ans = Math.min(ans, left + rAll);
		}
		// 0...N-1 左全部 右无
		ans = Math.min(ans, left + (str[N - 1] == 'G' ? 1 : 0));
		return ans;
	}

	public static void main(String[] args) {
		// String test = "GGGGGR";
		String test = "GRRRRRG";
		System.out.println(minPaint(test));
	}

}
