package com.lyx.everyDayTraining.braceExpansionII;

/*
1096. 花括号展开 II
如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。

花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：

如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
例如，表达式 {"a"} 表示字符串 "a"。
而表达式 {"w"} 就表示字符串 "w"。
当两个或多个表达式并列，以逗号分隔时，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}
例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"​​​​​​。
例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"。
给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。

假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。

示例 1：

输入："{a,b}{c,{d,e}}"
输出：["ac","ad","ae","bc","bd","be"]
示例 2：

输入："{{a,z},a{b,c},{ab,z}}"
输出：["a","ab","ac","z"]
解释：输出中 不应 出现重复的组合结果。
 */

/*
基于广度优先遍历
作者：tangweiqun
链接：https://leetcode-cn.com/problems/brace-expansion-ii/solution/biao-zhun-bfs-ti-jie-by-tangweiqun-6/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author lvyunxiao
 * @date 2020/9/29
 */
public class Solution {

    public List<String> braceExpansionII(String expression) {
        Queue<String> queue = new LinkedList<>();
        queue.add(expression);

        Set<String> res = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            // 拿到需要处理的表达式
            String exp = queue.poll();

            // 如果表达式中没有 {，则将这个表达式加入结果中
            if (!exp.contains("{")) {
                res.add(exp);
                continue;
            }

            // 找到表达式中第一对 {}
            // int i = 0;
            // int left = 0;
            // int right = 0;
            // while (exp.charAt(i) != '}') {
            //     if (exp.charAt(i) == '{') {
            //         left = i;
            //     }
            //     i++;
            // }
            // right = i;
            int left = 0;
            int right = exp.indexOf("}");
            for (int i = right - 1; i > 0; i--) {
                if (exp.charAt(i) == '{') {
                    left = i;
                    break;
                }
            }

            // System.out.println("exp: " + exp);
            // System.out.println("left: " + left);
            // System.out.println("right: " + right);

            // wrong when b{c,{d,e}}
            // int left2 = exp.indexOf("{");
            // int right2 = exp.indexOf("}");
            // System.out.println("left2: " + left2);
            // System.out.println("right2: " + right2);
            // System.out.println("=====================");

            // 拿到第一对括号中的前面部分 (不包括 {)
            String before = exp.substring(0, left);
            // 拿到第一对括号中的后面部分 (不包括 })
            String after = exp.substring(right + 1);
            // 按照 , 分割第一对括号中的元素 (不包括 {})
            String[] strs = exp.substring(left + 1, right).split(",");

            // 将 before 、 strs 中的每个元素以及 after 拼接成字符串放入到队列中，方便后面处理
            for (String str : strs) {
                sb.setLength(0);
                queue.add(sb.append(before).append(str).append(after).toString());
            }
        }
        // 结果处理
        List<String> ans = new ArrayList<>(res);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String exp = "{a,b}{c,{d,e}}";
        List<String> stringList = s.braceExpansionII(exp);
        System.out.println(Arrays.toString(stringList.toArray()));
    }

}
