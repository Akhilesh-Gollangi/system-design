package com.solid.SO.goodcode.threedshapes;

import com.solid.SO.goodcode.Shape3D;

public class Cube implements Shape3D {

    @Override
    public double calculateVolume(double dimension1) {
        return dimension1 * dimension1 * dimension1;
    }
}
