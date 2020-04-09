package com.jinm.flyweight;

import java.awt.*;

public class Oval implements Shape {

    private boolean fill;

    public Oval(boolean fill){
        this.fill = fill;
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
        if (fill){
            g.drawOval(x, y, width, height);
        }
    }

}
