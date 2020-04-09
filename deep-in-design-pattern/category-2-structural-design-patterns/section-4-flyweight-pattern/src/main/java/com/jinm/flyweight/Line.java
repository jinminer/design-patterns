package com.jinm.flyweight;

import java.awt.*;

public class Line implements Shape {

    public Line(){
        System.out.println("Creating Line object");
        //adding time delay
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g, int x, int y, int width, int height, Color color) {
        g.drawLine(x,y,width,height);
        g.setColor(color);
    }

}
