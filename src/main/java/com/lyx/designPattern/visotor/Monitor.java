package com.lyx.designPattern.visotor;

/**
 * @author lvyunxiao
 * @classname Monitor
 * @description Monitor
 * @date 2020/5/11
 */
public class Monitor implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
