package com.lyx.everyDayTraining.notOnlyMicro.matrix.strongPasswordChecker;

/*
420. 强密码检验器

如果一个密码满足下述所有条件，则认为这个密码是强密码：
    由至少 6 个，至多 20 个字符组成。
    至少包含 一个小写 字母，一个大写 字母，和 一个数字 。
    同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以算是强密码)。
给你一个字符串 password ，返回 将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
在一步修改操作中，你可以：
    插入一个字符到 password ，
    从 password 中删除一个字符，或
    用另一个字符来替换 password 中的某个字符。

示例 1：

输入：password = "a"
输出：5

示例 2：

输入：password = "aA1"
输出：3

示例 3：

输入：password = "1337C0d3"
输出：0

提示：
    1 <= password.length <= 50
    password 由字母、数字、点 '.' 或者感叹号 '!'
 */


/**
 * @author lvyunxiao
 * @date 2022/4/2
 * @description
 */
public class Solution {

    /*
    有bug，在String password = "aaaabbbbccccddeeddeeddeedd";出错，需要分类讨论
    public int strongPasswordChecker(String password) {
        int n = password.length();
        if (n < 3) {
            return 6 - n;
        }
        // 长度检查
        int lenthCheck = 0;
        if (n < 6) {
            lenthCheck = 6 - n;
        } else if (n > 20) {
            lenthCheck = n - 20;
        }

        // 同一个字符连续出现3次的次数
        int repeatCheck = 0;
        int curCount = 0;

        // 包含大写、小写、数字
        // charCheck[0] 包含大写字符，charCheck[1] 包含小写字符，charCheck[2] 包含数字
        boolean[] charCheckArr = new boolean[3];
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                charCheckArr[0] = true;
            } else if (c >= 'a' && c <= 'z') {
                charCheckArr[1] = true;
            } else if (c >= '0' && c <= '9') {
                charCheckArr[2] = true;
            }

            if (i % 3 != 0) {
                if (c == password.charAt(i - 1)) {
                    curCount++;
                    if (curCount == 2) {
                        repeatCheck++;
                        curCount = 0;
                    }
                } else {
                    curCount = 0;
                }
            }

        }
        int charCheck = 0;
        for (int i = 0; i < 3; i++) {
            if (!charCheckArr[i]) {
                charCheck++;
            }
        }
        int ans = 0;
        if (n > 20) {
            ans = Math.max(lenthCheck + charCheck, lenthCheck + repeatCheck);
        } else {
            ans = Math.max(Math.max(lenthCheck, charCheck), repeatCheck);
        }
        return ans;
    }
     */

    public int strongPasswordChecker(String password) {
        int n = password.length();
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (int i = 0; i < n; i++) {
            char ch = password.charAt(i);
            if (Character.isLowerCase(ch)) {
                hasLower = 1;
            } else if (Character.isUpperCase(ch)) {
                hasUpper = 1;
            } else if (Character.isDigit(ch)) {
                hasDigit = 1;
            }
        }
        int categories = hasLower + hasUpper + hasDigit;

        if (n < 6) {
            return Math.max(6 - n, 3 - categories);
        } else if (n <= 20) {
            int replace = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; i++) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    cnt++;
                } else {
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            replace += cnt / 3;
            return Math.max(replace, 3 - categories);
        } else {
            // 替换次数和删除次数
            int replace = 0, remove = n - 20;
            // k mod 3 = 1 的组数，即删除 2 个字符可以减少 1 次替换操作
            int rm2 = 0;
            int cnt = 0;
            char cur = '#';

            for (int i = 0; i < n; i++) {
                char ch = password.charAt(i);
                if (ch == cur) {
                    cnt++;
                } else {
                    if (remove > 0 && cnt >= 3) {
                        if (cnt % 3 == 0) {
                            // 如果是 k % 3 = 0 的组，那么优先删除 1 个字符，减少 1 次替换操作
                            --remove;
                            --replace;
                        } else if (cnt % 3 == 1) {
                            // 如果是 k % 3 = 1 的组，那么存下来备用
                            ++rm2;
                        }
                        // k % 3 = 2 的组无需显式考虑
                    }
                    replace += cnt / 3;
                    cnt = 1;
                    cur = ch;
                }
            }
            if (remove > 0 && cnt >= 3) {
                if (cnt % 3 == 0) {
                    remove--;
                    replace--;
                } else if (cnt % 3 == 1) {
                    rm2++;
                }
            }
            replace += cnt / 3;

            // 使用 k % 3 = 1 的组的数量，由剩余的替换次数、组数和剩余的删除次数共同决定
            int use2 = Math.min(Math.min(replace, rm2), remove / 2);
            replace -= use2;
            remove -= use2 * 2;
            // 由于每有一次替换次数就一定有 3 个连续相同的字符（k / 3 决定），因此这里可以直接计算出使用 k % 3 = 2 的组的数量
            int use3 = Math.min(replace, remove / 3);
            replace -= use3;
            remove -= use3 * 3;
            return (n - 20) + Math.max(replace, 3 - categories);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        // String password = "1337C0d3";
        // String password = "aa123";
        // String password = "1111111111";
        // String password = "ABABABABABABABABABAB1";
        // String password = "bbaaaaaaaaaaaaaaacccccc";
        String password = "aaaabbbbccccddeeddeeddeedd";
        int strongPasswordChecker = s.strongPasswordChecker(password);
        System.out.println(strongPasswordChecker);
    }
}
