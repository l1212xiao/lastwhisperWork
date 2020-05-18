package com.lyx.designPattern.template;

/**
 * @author lvyunxiao
 * @classname Game
 * @description Game
 * @date 2020/5/11
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
