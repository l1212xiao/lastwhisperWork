package com.lyx.designPattern.adapter;

/**
 * @author lvyunxiao
 * @classname VlcPlayer
 * @description VlcPlayer
 * @date 2020/5/9
 */
public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file. Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        //什么也不做
    }
}
