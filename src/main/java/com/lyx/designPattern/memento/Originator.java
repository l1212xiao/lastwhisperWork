package com.lyx.designPattern.memento;

/**
 * @author lvyunxiao
 * @classname Originator
 * @description Originator
 * @date 2020/5/11
 */
public class Originator {
    private String state;

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public Memento saveStateToMemento(){
        return new Memento(state);
    }

    public void getStateFromMemento(Memento Memento){
        state = Memento.getState();
    }
}
