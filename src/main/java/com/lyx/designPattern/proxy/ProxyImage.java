package com.lyx.designPattern.proxy;

/**
 * @author lvyunxiao
 * @classname ProxyImage
 * @description ProxyImage
 * @date 2020/5/6
 */
public class ProxyImage implements Image{

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName){
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null){
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}