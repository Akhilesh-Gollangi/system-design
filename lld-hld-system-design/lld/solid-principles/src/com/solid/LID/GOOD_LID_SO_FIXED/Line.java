package com.solid.LID.GOOD_LID_SO_FIXED;

public class Line implements IShape1D {

    private double length;

    public Line(double length) {
        this.length = length;
    }

    @Override
    public double getPerimeter() {
        return length;
    }

}