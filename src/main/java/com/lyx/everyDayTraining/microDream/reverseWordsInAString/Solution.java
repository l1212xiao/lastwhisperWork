package com.lyx.everyDayTraining.microDream.reverseWordsInAString;

/*
151. 翻转字符串里的单词

给你一个字符串 s ，逐个翻转字符串中的所有 单词 。
单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。

说明：
    输入字符串 s 可以在前面、后面或者单词间包含多余的空格。
    翻转后单词间应当仅用一个空格分隔。
    翻转后的字符串中不应包含额外的空格。

示例 1：

输入：s = "the sky is blue"
输出："blue is sky the"

示例 2：

输入：s = "  hello world  "
输出："world hello"
解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。

示例 3：

输入：s = "a good   example"
输出："example good a"
解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。

示例 4：

输入：s = "  Bob    Loves  Alice   "
输出："Alice Loves Bob"

示例 5：

输入：s = "Alice does not even like bob"
输出："bob like even not does Alice"

提示：
    1 <= s.length <= 104
    s 包含英文大小写字母、数字和空格 ' '
    s 中 至少存在一个 单词

进阶：
    请尝试使用 O(1) 额外空间复杂度的原地解法。
 */


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author lvyunxiao
 * @date 2022/3/7
 * @description
 */
public class Solution {

    // 使用API
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    /*
    split 逆序
     */
    public String reverseWords2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        // String[] sArr = s.trim().split(" ");
        String[] sArr = s.trim().split("( )+");
        StringBuilder sb = new StringBuilder();
        for (int i = sArr.length - 1; i >= 0; i--) {
            if (sArr[i].length() > 0) {
                sb.append(sArr[i]);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    // 双指针 + 双端队列
    public String reverseWords3(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }


    // 递归 -超时
    public String reverseWords4(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        int i = 0, j = s.length() - 1;
        while (i < s.length() - 1 && s.charAt(i) != ' ') {
            i++;
        }
        while (j > 0 && s.charAt(j) != ' ') {
            j--;
        }
        if (i <= j) {
            if (reverseWords(s.substring(i, j)).trim().length() == 0) {
                s = s.substring(j).trim() + " " + s.substring(0, i).trim();
            } else {
                s = s.substring(j).trim() + " " + reverseWords(s.substring(i, j)).trim() + " "
                    + s.substring(0, i).trim();
            }
        }
        return s;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // String str = "the sky is blue";
        // String str = "  Bob    Loves  Alice   ";
        // String str = "Alice does not even like bob";
        String str = " gtUGyw       sQ       ZaYYygdFe    Rep6lU  o z      QcspISw       k0b9Ts   KkkRVXY7   OUVxX1zsUL      aQ7iiTy      nKCtoS8       Jp  15uAqvNl   W9Mqf7cep    c      WZJ0M3Z       kX       J     en       wUb6 yY     9v      6eq hQs UmNRei   qEjVjL      xmhQMptz   kT     VBLWqIJXRi       qM      L3jQ78    p    TZH     glfOAYah40   GsaSwLnOs     zIiIXd     YgHsUKFd     i7      0       11lASBGl   LKg3a    LDtzIOvWLt   vPKksW Aa  LFTT      M6FyWJ  y5j02N      lKw sBmxVa1Eh     eLl uM2P  q4    7W8r   GV9    KipYyS0 S pA";
        String reverseWords = s.reverseWords(str);
        System.out.println(reverseWords);

    }

}
