package com.lyx.OwnLearning.StringOp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lyx on 2018/8/8.
 * 定义字符串A和B相似，当且仅当A和B中所有字符出现的次数均相等，请实现一个函数，判断A和B是否相似
 */
public class StringSim {
    public static boolean isSim(String A, String B) {
        if (A.length() != B.length()) return false;

        HashMap<Character, Integer> mapA = toMap(A);
        HashMap<Character, Integer> mapB = toMap(B);

        //Set<Map.Entry<Character, Integer>> entries = mapA.entrySet();
        for (Map.Entry<Character, Integer> strEntry : mapA.entrySet()) {
            Character key = strEntry.getKey();
            if (!mapB.containsKey(key) || mapB.get(key) != mapA.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> toMap(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!map.containsKey(str.charAt(i))) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        String strA = "aac";
        String strB = "caab";
        boolean isSim = isSim(strA, strB);
        System.out.println(isSim);

    }
}
