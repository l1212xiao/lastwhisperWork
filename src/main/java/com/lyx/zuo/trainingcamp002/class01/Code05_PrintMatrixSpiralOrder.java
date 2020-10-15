package com.lyx.zuo.trainingcamp002.class01;

/**
 * 转圈打印矩阵
 */
public class Code05_PrintMatrixSpiralOrder {

    public static void spiralOrderPrint(int[][] matrix) {
        int aR = 0;
        int aC = 0;
        int bR = matrix.length - 1;
        int bC = matrix[0].length - 1;
        while (aR <= bR && aC <= bC) {
            printEdge(matrix, aR++, aC++, bR--, bC--);
        }
    }

    public static void printEdge(int[][] m, int aR, int aC, int bR, int bC) {
        if (aR == bR) {
            for (int i = aC; i <= bC; i++) {
                System.out.print(m[aR][i] + " ");
            }
        } else if (aC == bC) {
            for (int i = aR; i <= bR; i++) {
                System.out.print(m[i][aC] + " ");
            }
        } else {
            int curR = aR;
            int curC = aC;
            while (curC != bC) {
                System.out.print(m[aR][curC] + " ");
                curC++;
            }
            while (curR != bR) {
                System.out.print(m[curR][bC] + " ");
                curR++;
            }
            while (curC != aC) {
                System.out.print(m[bR][curC] + " ");
                curC--;
            }
            while (curR != aR) {
                System.out.print(m[curR][aC] + " ");
                curR--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        spiralOrderPrint(matrix);

    }

}
