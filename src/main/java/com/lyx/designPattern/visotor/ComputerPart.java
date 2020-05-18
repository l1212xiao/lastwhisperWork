package com.lyx.designPattern.visotor;

/**
 * @author lvyunxiao
 * @classname ComputerPart
 * @description ComputerPart
 * @date 2020/5/11
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}
