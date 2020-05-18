package com.lyx.designPattern.template;

/**
 * @author lvyunxiao
 * @classname Cricket
 * @description Cricket
 * @date 2020/5/11
 */
public class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
