package com.lyx.designPattern.chainOfResponsibility;

/**
 * @author lvyunxiao
 * @classname ErrorLogger
 * @description ErrorLogger
 * @date 2020/4/27
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error Console::Logger: " + message);
    }
}
