package com.lyx.designPattern.visotor;

/**
 * @author lvyunxiao
 * @classname ComputerPartVisitor
 * @description ComputerPartVisitor
 * @date 2020/5/11
 */
public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);

    void visit(Monitor monitor);
}
