package com.jinm.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite object
 */
public class Drawing implements Shape {

    List<Shape> shapes = new ArrayList<>();

    @Override
    public void draw(String color) {
        for (Shape shape : shapes){
            shape.draw(color);
        }
    }

    public void add(Shape shape){
        shapes.add(shape);
    }

    public void remove(Shape shape){
        shapes.remove(shape);
    }

    public void clear(){
        shapes.clear();
    }

}
