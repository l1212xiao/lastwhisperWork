package com.lyx.OwnLearning.MyOwn.onlyOnceChar;

import java.util.ArrayList;

/**
 * Created by lyx on 2018/5/22.
 */
public class OnlyOnceChar {
    public static char onlyOnceChar(String str) {
        char[] chars = str.toCharArray();
        ArrayList<Character> list = new ArrayList<Character>();
        for (char c : chars) {
            list.add(c);
        }

        for (int i = 0; i < list.size(); i++) {
            Character c = list.get(i);
            list.remove(i);
            if (!list.contains(c)) {
                return c;
            } else {
                list.add(i, c);
            }
        }
        return chars[0];

    }

    public static void main(String[] args) {
        String str = "abaccdeff";
        char c = onlyOnceChar(str);
        System.out.println(c);
    }
}
