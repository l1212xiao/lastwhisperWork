package com.lyx.designPattern.state;

/**
 * @author lvyunxiao
 * @classname StopState
 * @description StopState
 * @date 2020/5/11
 */
public class StopState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
