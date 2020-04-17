package com.lyx.msb.tank.base;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author lvyunxiao
 * @classname FrameDemo
 * @description FrameDemo
 * @date 2020/4/15
 */
public class FrameDemo {

    public static void main(String[] args) {

        Frame f = new Frame();
        f.setSize(800, 600);
        // f.setResizable(false);
        f.setTitle("tank war");
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
