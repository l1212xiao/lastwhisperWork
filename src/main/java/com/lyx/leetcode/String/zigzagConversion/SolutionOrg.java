package com.lyx.leetcode.String.zigzagConversion;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname SolutionOrg
 * @Description SolutionOrg
 * @Date 2019/8/20
 * @auther lvyunxiao
 * <p>
 * https://leetcode-cn.com/problems/zigzag-conversion/solution/z-zi-xing-bian-huan-by-leetcode/
 * <p>
 * 思路
 * 通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
 * 算法
 * 我们可以使用 \text{min}( \text{numRows}, \text{len}(s))min(numRows,len(s)) 个列表来表示 Z 字形图案中的非空行。
 * 从左到右迭代 ss，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
 * 只有当我们向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
 */
public class SolutionOrg {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (final StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        SolutionOrg solutionOrg = new SolutionOrg();
        String s = solutionOrg.convert("LEETCODEISHIRING", 3);
        System.out.println(s);
    }
}
