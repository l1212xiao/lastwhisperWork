package com.lyx.designPattern.adapter;

/**
 * @author lvyunxiao
 * @classname AdvancedMediaPlayer
 * @description AdvancedMediaPlayer
 * @date 2020/5/9
 */
public interface AdvancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
