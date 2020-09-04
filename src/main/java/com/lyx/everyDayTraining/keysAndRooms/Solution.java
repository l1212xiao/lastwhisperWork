package com.lyx.everyDayTraining.keysAndRooms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author lvyunxiao
 * @date 2020/8/31
 */
public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(0);
        set.add(0);
        while (!queue.isEmpty()) {
            Integer room = queue.poll();
            List<Integer> keys = rooms.get(room);
            for (int i = 0; i < keys.size(); i++) {
                if (!set.contains(keys.get(i))) {
                    set.add(keys.get(i));
                    queue.add(keys.get(i));
                }
            }
        }
        return set.size() == rooms.size();
    }

    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> set = new HashSet<>();
        stack.push(0);
        set.add(0);
        while (!stack.isEmpty()) {
            Integer room = stack.pop();
            List<Integer> keys = rooms.get(room);
            for (int i = 0; i < keys.size(); i++) {
                if (!set.contains(keys.get(i))) {
                    set.add(keys.get(i));
                    stack.push(keys.get(i));
                }
            }
        }
        return set.size() == rooms.size();
    }
}
