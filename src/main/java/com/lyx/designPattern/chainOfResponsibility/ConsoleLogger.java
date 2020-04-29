package com.lyx.designPattern.chainOfResponsibility;

/**
 * @author lvyunxiao
 * @classname ConsoleLogger
 * @description ConsoleLogger
 * @date 2020/4/27
 */
public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Standard Console::Logger: " + message);
    }
}
