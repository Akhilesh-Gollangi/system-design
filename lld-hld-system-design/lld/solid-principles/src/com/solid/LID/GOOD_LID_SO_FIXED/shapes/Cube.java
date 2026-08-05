package com.solid.LID.GOOD_LID_SO_FIXED.shapes;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape3D;

public class Cube implements IShape3D {

    private double side;

    public Cube(double side) {
        this.side = side;
    }

    @Override
    public double getVolume() {
        return Math.pow(side, 3);
    }

    @Override
    public double getArea() {
        return 6 * Math.pow(side, 2);
    }
}
