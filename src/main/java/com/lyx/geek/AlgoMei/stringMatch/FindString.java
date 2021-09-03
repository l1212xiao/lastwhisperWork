package com.lyx.geek.AlgoMei.stringMatch;

/**
 * @author lvyunxiao
 * @date 2021/8/4
 * @description ref:https://time.geekbang.org/column/article/71187
 *
 * 假设有下面这样一个二维字符串矩阵（图中的主串），借助今天讲的处理思路，如何在其中查找另一个二维字符串矩阵（图中的模式串）呢？
 */
public class FindString {

    /**
     * a b c d e
     * f g h i j
     * k l m n o
     * p q r s t
     * u v w x y
     * <p>
     * h i
     * m n
     */
    public static void find(char[][] mainChars, char[][] modeChars) {
        int modeWidth = modeChars.length;
        int modeHeight = modeChars[0].length;

        String modeString = getMode(modeChars, modeWidth, modeHeight, 0, 0);

        for (int i = 0; i <= mainChars.length - modeWidth; i++) {
            for (int j = 0; j <= mainChars.length - modeHeight; j++) {
                String mode = getMode(mainChars, modeWidth, modeHeight, i, j);
                if (modeString.equals(mode)) {
                    System.out.println("x:" + i + "->" + (i + modeWidth - 1));
                    System.out.println("y:" + j + "->" + (j + modeHeight - 1));
                }
            }
        }

    }

    public static String getMode(char[][] chars, int width, int height, int x, int y) {
        StringBuilder str = new StringBuilder();
        for (int k = 0; k < width; k++) {
            for (int l = 0; l < height; l++) {
                str.append(chars[x + k][y + l]);
            }
        }
        return str.toString();
    }
}
