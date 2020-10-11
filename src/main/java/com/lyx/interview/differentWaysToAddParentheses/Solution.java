package com.lyx.interview.differentWaysToAddParentheses;

/*
241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。

示例 1:

输入: "2-1-1"
输出: [0, 2]
解释:
((2-1)-1) = 0
(2-(1-1)) = 2
示例 2:

输入: "2*3-4*5"
输出: [-34, -14, -10, -10, 10]
解释:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
 */

/*
解法一 递归
一看到题就觉得有点复杂，可以考虑一下递归的方式，去寻找子问题和原问题解的关系。

可以通过运算符把整个式子分成两部分，两部分再利用递归解决。

以 2 * 3 - 4 * 5 为例。
2 和 3 - 4 * 5 两部分，中间是 * 号相连。
2 * 3 和 4 * 5 两部分，中间是 - 号相连。
2 * 3 - 4 和 5 两部分，中间是 * 号相连。

有了两部分的结果，然后再通过中间的符号两两计算加入到最终的结果中即可。
比如第一种情况，2 和 3 - 4 * 5 两部分，中间是 * 号相连。
2 的解就是 [2]，3 - 4 * 5 的解就是 [-5, -17]。
把两部分解通过 * 号计算，最终结果就是 [-10, -34]。
另外两种情况也类似。
然后还需要递归出口。
如果给定的字符串只有数字，没有运算符，那结果就是给定的字符串转为数字。
比如上边的第一种情况，2 的解就是 [2]。

作者：windliang
链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-5-5/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author lyx
 * @create 2020-10-11 23:19
 */
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        //考虑是全数字的情况
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        //将全数字的情况直接返回
        if (index == input.length()) {
            result.add(num);
            return result;
        }

        for (int i = 0; i < input.length(); i++) {
            //通过运算符将字符串分成两部分
            if (isOperation(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                //将两个结果依次运算
                for (int r1 : result1) {
                    for (int r2 : result2) {
                        char op = input.charAt(i);
                        result.add(caculate(r1, op, r2));
                    }
                }
            }
        }
        return result;
    }

    private int caculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }

    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }


    // 由于递归是两个分支，所以会有一些的解进行了重复计算，我们可以通过 memoization 技术，
    // 前边很多题都用过了，一种空间换时间的方法。
    // 将递归过程中的解保存起来，如果第二次递归过来，直接返回结果即可，无需重复递归。
    // 将解通过 map 存储，其中，key 存储函数入口参数的字符串，value 存储当前全部解的一个 List 。

    //添加一个 map
    HashMap<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute2(String input) {
        if (input.length() == 0) {
            return new ArrayList<>();
        }
        //如果已经有当前解了，直接返回
        if (map.containsKey(input)) {
            return map.get(input);
        }
        List<Integer> result = new ArrayList<>();
        int num = 0;
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        if (index == input.length()) {
            result.add(num);
            //存到 map
            map.put(input, result);
            return result;
        }
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(caculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        //存到 map
        map.put(input, result);
        return result;
    }


    public static void main(String[] args) {
        String input = "2*3-4*5";
        Solution s = new Solution();
        List<Integer> list = s.diffWaysToCompute(input);
        System.out.println(Arrays.toString(list.toArray()));
    }
}
