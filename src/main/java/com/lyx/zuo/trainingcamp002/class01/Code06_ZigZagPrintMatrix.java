package com.lyx.zuo.trainingcamp002.class01;

/*
原地旋转正方形矩阵
 */
public class Code06_ZigZagPrintMatrix {

	public static void printMatrixZigZag(int[][] matrix) {
		int aR = 0;		//	A的行号
		int aC = 0;		//	A的列号
		int bR = 0;		//	B的行号
		int bC = 0;		//	B的列号
		int endR = matrix.length - 1;
		int endC = matrix[0].length - 1;
		boolean fromUp = false;	//是不是从右上往左下打印
		while (aR != endR + 1) {
			printLevel(matrix, aR, aC, bR, bC, fromUp);
			// A 先往右走，走到不能再走再往下
			aR = aC == endC ? aR + 1 : aR;
			aC = aC == endC ? aC : aC + 1;
			// B先往下走，走到不能再走再往右
			bC = bR == endR ? bC + 1 : bC;
			bR = bR == endR ? bR : bR + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
			boolean f) {
		if (f) {
			while (tR != dR + 1) {
				System.out.print(m[tR++][tC--] + " ");
			}
		} else {
			while (dR != tR - 1) {
				System.out.print(m[dR--][dC++] + " ");
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		printMatrixZigZag(matrix);

	}

}
