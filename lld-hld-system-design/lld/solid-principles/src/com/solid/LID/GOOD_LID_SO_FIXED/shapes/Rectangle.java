package com.solid.LID.GOOD_LID_SO_FIXED.shapes;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape2D;

public class Rectangle implements IShape2D {

    private double length;
    private double breadth;

    public Rectangle(double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    public double getArea() {
        return length * breadth;
    }

    @Override
    public double getPerimeter() {
        return 2 * (length + breadth);
    }
}