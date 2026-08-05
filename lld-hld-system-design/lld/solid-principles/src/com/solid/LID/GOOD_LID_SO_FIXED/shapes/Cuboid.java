package com.solid.LID.GOOD_LID_SO_FIXED.shapes;

public class Cuboid {

    private double length;
    private double breadth;
    private double height;

    public Cuboid(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }

    public double getVolume() {
        return length * breadth * height;
    }
}
