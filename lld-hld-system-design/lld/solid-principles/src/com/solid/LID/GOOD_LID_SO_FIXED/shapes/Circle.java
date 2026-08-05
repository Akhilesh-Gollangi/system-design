package com.solid.LID.GOOD_LID_SO_FIXED.shapes;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape2D;

public class Circle implements IShape2D {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

}