package com.lyx.designPattern.memento;

/**
 * @author lvyunxiao
 * @classname Memento
 * @description Memento
 * @date 2020/5/11
 */
public class Memento {
    private String state;

    public Memento(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }
}
