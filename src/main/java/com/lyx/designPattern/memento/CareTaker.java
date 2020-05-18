package com.lyx.designPattern.memento;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lvyunxiao
 * @classname CareTaker
 * @description CareTaker
 * @date 2020/5/11
 */
public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state){
        mementoList.add(state);
    }

    public Memento get(int index){
        return mementoList.get(index);
    }
}