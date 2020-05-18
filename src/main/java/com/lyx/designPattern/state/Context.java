package com.lyx.designPattern.state;

/**
 * @author lvyunxiao
 * @classname Context
 * @description Context
 * @date 2020/5/11
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
