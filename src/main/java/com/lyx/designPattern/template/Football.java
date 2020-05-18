package com.lyx.designPattern.template;

/**
 * @author lvyunxiao
 * @classname Football
 * @description Football
 * @date 2020/5/11
 */
public class Football extends Game {

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }
}
