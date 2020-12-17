package com.lyx.everyDayTraining.beforeMeituan.judgeCircle;

/**
 * @author lvyunxiao
 * @date 2020/8/28
 */
public class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for(int i=0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'R')  x++;
            if(moves.charAt(i) == 'L')  x--;
            if(moves.charAt(i) == 'U')  y++;
            if(moves.charAt(i) == 'D')  y--;
        }
        return (x == 0) && (y == 0);
    }
}
