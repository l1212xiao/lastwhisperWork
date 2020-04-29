package com.lyx.designPattern.chainOfResponsibility;

/**
 * @author lvyunxiao
 * @classname FileLogger
 * @description FileLogger
 * @date 2020/4/27
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("File::Logger: " + message);
    }
}
