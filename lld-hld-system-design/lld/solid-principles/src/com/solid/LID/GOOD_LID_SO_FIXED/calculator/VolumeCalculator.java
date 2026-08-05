package com.solid.LID.GOOD_LID_SO_FIXED.calculator;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape3D;

public class VolumeCalculator {

    private final IShape3D shape3D;

    public VolumeCalculator(IShape3D shape3D) {
        this.shape3D = shape3D;
    }

    public double calculateVolume() {
        return shape3D.getVolume(); // runtime polymorphism
    }
}
