package com.lyx.designPattern.proxy;

/**
 * @author lvyunxiao
 * @classname RealImage
 * @description RealImage
 * @date 2020/5/6
 */
public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName){
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadFromDisk(String fileName){
        System.out.println("Loading " + fileName);
    }
}
