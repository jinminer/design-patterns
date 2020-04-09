package com.jinm.composite;

/**
 * Composite Design Pattern Leaf Objects
 */
public class Triangle implements Shape {

    @Override
    public void draw(String color) {
        System.out.println("Drawing Triangle with color "+color);
    }

}
