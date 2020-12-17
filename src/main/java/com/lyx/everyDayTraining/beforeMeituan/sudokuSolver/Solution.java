package com.lyx.everyDayTraining.beforeMeituan.sudokuSolver;

/*
37. 解数独
编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
 */

/*
前言
我们可以考虑按照「行优先」的顺序依次枚举每一个空白格中填的数字，通过递归 + 回溯的方法枚举所有可能的填法。
当递归到最后一个空白格后，如果仍然没有冲突，说明我们找到了答案；
在递归的过程中，如果当前的空白格不能填下任何一个数字，那么就进行回溯。

由于每个数字在同一行、同一列、同一个九宫格中只会出现一次，
因此我们可以使用 line[i]，column[j]，block[x][y]
分别表示第 i 行，第 j 列，第 (x, y) 个九宫格中填写数字的情况。
在下面给出的三种方法中，我们将会介绍两种不同的表示填写数字情况的方法。

九宫格的范围为 0 <= x <= 2 以及 0 <= y <= 2。
具体地，第 i 行第 j 列的格子位于第 (\lfloor i/3 \rfloor, \lfloor j/3 \rfloor)(⌊i/3⌋,⌊j/3⌋) 个九宫格中，
其中 \lfloor u \rfloor⌊u⌋ 表示对 u 向下取整。

由于这些方法均以递归 + 回溯为基础，算法运行的时间（以及时间复杂度）
很大程度取决于给定的输入数据，而我们很难找到一个非常精确的渐进紧界。
因此这里只给出一个较为宽松的渐进复杂度上界 o(9^9*9)，即最多有 9×9 个空白格，每个格子可以填 [1, 9] 中的任意整数。

方法一：递归
思路

最容易想到的方法是用一个数组记录每个数字是否出现。由于我们可以填写的数字范围为 [1, 9]，
而数组的下标从 0 开始，因此在存储时，我们使用一个长度为 9 的布尔类型的数组，其中 i 个元素的值为 True，
当且仅当数字 i+1 出现过。例如我们用 line[2][3]=True 表示数字 4 在第 2 行已经出现过，
那么当我们在遍历到第 2 行的空白格时，就不能填入数字 4。

算法

我们首先对整个数独数组进行遍历，当我们遍历到第 i 行第 j 列的位置：
如果该位置是一个空白格，那么我们将其加入一个用来存储空白格位置的列表中，方便后续的递归操作；
如果该位置是一个数字 x，那么我们需要将 line[i][x−1]，column[j][x−1] 以及 block[⌊i/3⌋][⌊j/3⌋][x−1] 均置为 True。

当我们结束了遍历过程之后，就可以开始递归枚举。当递归到第 i 行第 j 列的位置时，
我们枚举填入的数字 x。根据题目的要求，数字 x 不能和当前行、列、九宫格中已经填入的数字相同，
因此 line[i][x−1]，column[j][x−1] 以及 block[⌊i/3⌋][⌊j/3⌋][x−1] 必须均为 False。

当我们填入了数字 x 之后，我们要将上述的三个值都置为 True，并且继续对下一个空白格位置进行递归。
在回溯到当前递归层时，我们还要将上述的三个值重新置为 False。

作者：LeetCode-Solution
链接：https://leetcode-cn.com/problems/sudoku-solver/solution/jie-shu-du-by-leetcode-solution/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2020/9/15
 */
public class Solution {
    private boolean[][] line = new boolean[9][9];
    private boolean[][] column = new boolean[9][9];
    private boolean[][][] block = new boolean[3][3][9];
    private boolean valid = false;
    private List<int[]> spaces = new ArrayList<int[]>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                } else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                }
            }
        }

        dfs(board, 0);
    }

    public void dfs(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int digit = 0; digit < 9 && !valid; ++digit) {
            if (!line[i][digit] && !column[j][digit] && !block[i / 3][j / 3][digit]) {
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = true;
                board[i][j] = (char) (digit + '0' + 1);
                dfs(board, pos + 1);
                line[i][digit] = column[j][digit] = block[i / 3][j / 3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[9][9];
        board[0] = new char[]{'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        board[1] = new char[]{'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        board[2] = new char[]{'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        board[3] = new char[]{'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        board[4] = new char[]{'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        board[5] = new char[]{'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        board[6] = new char[]{'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        board[7] = new char[]{'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        board[8] = new char[]{'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        s.solveSudoku(board);
        System.out.println("===============================");
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
        System.out.println("===============================");

        // System.out.println(Arrays.deepToString(board));
    }

}
