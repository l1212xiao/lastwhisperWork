package com.lyx.designPattern.adapter;

/**
 * @author lvyunxiao
 * @classname Mp4Player
 * @description Mp4Player
 * @date 2020/5/9
 */
public class Mp4Player implements AdvancedMediaPlayer{

    @Override
    public void playVlc(String fileName) {
        //什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file. Name: "+ fileName);
    }
}
