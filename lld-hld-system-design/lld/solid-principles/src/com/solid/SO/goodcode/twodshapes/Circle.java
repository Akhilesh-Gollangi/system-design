package com.solid.SO.goodcode.twodshapes;

import com.solid.SO.goodcode.Shape2D;

public class Circle implements Shape2D {
    @Override
    public double calculateArea(double dimension1, double dimension2) {
        return Math.PI * dimension1 * dimension1;
    }
}
