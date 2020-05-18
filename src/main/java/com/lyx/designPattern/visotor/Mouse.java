package com.lyx.designPattern.visotor;

/**
 * @author lvyunxiao
 * @classname Mouse
 * @description Mouse
 * @date 2020/5/11
 */
public class Mouse  implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
