package com.lyx.everyDayTraining.microDream.designTicTacToe;

/*
348. 设计井字棋

请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。
在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。
在实现这个判定器的过程中，你可以假设以下这些规则一定成立：

      1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里；
      2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续；
      3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。

示例:

给定棋盘边长 n = 3, 玩家 1 的棋子符号是 "X"，玩家 2 的棋子符号是 "O"。

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> 函数返回 0 (此时，暂时没有玩家赢得这场对决)
|X| | |
| | | |    // 玩家 1 在 (0, 0) 落子。
| | | |

toe.move(0, 2, 2); -> 函数返回 0 (暂时没有玩家赢得本场比赛)
|X| |O|
| | | |    // 玩家 2 在 (0, 2) 落子。
| | | |

toe.move(2, 2, 1); -> 函数返回 0 (暂时没有玩家赢得比赛)
|X| |O|
| | | |    // 玩家 1 在 (2, 2) 落子。
| | |X|

toe.move(1, 1, 2); -> 函数返回 0 (暂没有玩家赢得比赛)
|X| |O|
| |O| |    // 玩家 2 在 (1, 1) 落子。
| | |X|

toe.move(2, 0, 1); -> 函数返回 0 (暂无玩家赢得比赛)
|X| |O|
| |O| |    // 玩家 1 在 (2, 0) 落子。
|X| |X|

toe.move(1, 0, 2); -> 函数返回 0 (没有玩家赢得比赛)
|X| |O|
|O|O| |    // 玩家 2 在 (1, 0) 落子.
|X| |X|

toe.move(2, 1, 1); -> 函数返回 1 (此时，玩家 1 赢得了该场比赛)
|X| |O|
|O|O| |    // 玩家 1 在 (2, 1) 落子。
|X|X|X|


进阶:
您有没有可能将每一步的 move() 操作优化到比 O(n2) 更快吗?

 */


/**
 * @author lvyunxiao
 * @date 2022/4/12
 * @description
 */
class TicTacToe {

    int n;

    int[][] mat;

    public TicTacToe(int n) {
        this.n = n;
        this.mat = new int[n][n];
    }

    public int move(int row, int col, int player) {
        mat[row][col] = player;

        out:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != player) {
                    continue out;
                }
            }
            return player;
        }
        out:
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (mat[i][j] != player) {
                    continue out;
                }
            }
            return player;
        }

        // 主对角线
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (mat[i][j] != player) {
                break;
            }
            if (i == n - 1) {
                return player;
            }
        }

        // 副对角线
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (mat[i][j] != player) {
                break;
            }
            if (i == n - 1) {
                return player;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        System.out.println(ticTacToe.move(0, 1, 2));
        System.out.println(ticTacToe.move(1, 0, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
    }
}

class TicTacToe2 {

    int n;

    int[][] mat;

    public TicTacToe2(int n) {
        this.n = n;
        this.mat = new int[n][n];
    }

    public int move(int row, int col, int player) {

        mat[row][col] = player;

        // 判断所在行
        for (int j = 0; j < n; j++) {
            if (mat[row][j] != player) {
                break;
            }
            if (j == n - 1) {
                return player;
            }
        }

        // 判断所在列
        for (int i = 0; i < n; i++) {
            if (mat[i][col] != player) {
                break;
            }
            if (i == n - 1) {
                return player;
            }
        }

        // 主对角线
        for (int i = 0, j = 0; i < n; i++, j++) {
            if (mat[i][j] != player) {
                break;
            }
            if (i == n - 1) {
                return player;
            }
        }

        // 副对角线
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            if (mat[i][j] != player) {
                break;
            }
            if (i == n - 1) {
                return player;
            }
        }
        return 0;

    }

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe(2);
        System.out.println(ticTacToe.move(0, 1, 2));
        System.out.println(ticTacToe.move(1, 0, 1));
        System.out.println(ticTacToe.move(1, 1, 2));
    }
}

/*
【数组】

*/
class TicTacToe3 {

    // 记住每行，每列，对角线的当前情况
    int[][] rows;
    int[][] columns;
    int[][] diagonals;
    int n;

    public TicTacToe3(int n) {
        rows = new int[n][2]; // 记录每一行的状态，[x的数量, o的数量]
        columns = new int[n][2];
        diagonals = new int[n][2];
        this.n = n;
    }

    public int move(int row, int col, int player) {
        rows[row][player - 1]++;
        if (rows[row][player - 1] == n) {
            return player;
        }
        columns[col][player - 1]++;
        if (columns[col][player - 1] == n) {
            return player;
        }
        if (row == col) {
            diagonals[0][player - 1]++;
        }
        if (diagonals[0][player - 1] == n) {
            return player;
        }
        if (row + col == n - 1) {
            diagonals[1][player - 1]++;
        }
        if (diagonals[1][player - 1] == n) {
            return player;
        }
        return 0;
    }
}

class TicTacToe4 {

    // if row == col means in the diagonal
    private int diagonal;

    // if col = size - row - 1 in the reverse diagonal
    private int reverseDiagonal;

    private int[] rows;

    private int[] cols;

    private int size;

    public TicTacToe4(int n) {
        this.size = n;
        this.rows = new int[n];
        this.cols = new int[n];
    }

    public int move(int row, int col, int player) {
        int toAdd = player == 1 ? 1 : -1;

        rows[row] += toAdd;
        cols[col] += toAdd;

        if (row == col) {
            diagonal += toAdd;
        }

        if (row + col == size - 1) {
            reverseDiagonal += toAdd;
        }

        if (Math.abs(rows[row]) == size
            || Math.abs(cols[col]) == size
            || Math.abs(diagonal) == size
            || Math.abs(reverseDiagonal) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */


