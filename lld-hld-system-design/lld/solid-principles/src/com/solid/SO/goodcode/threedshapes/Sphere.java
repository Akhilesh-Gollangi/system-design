package com.solid.SO.goodcode.threedshapes;

import com.solid.SO.goodcode.Shape3D;

public class Sphere implements Shape3D {
    @Override
    public double calculateVolume(double dimension1) {
        return (4.0 / 3.0) * Math.PI * dimension1 * dimension1 * dimension1;
    }
}
