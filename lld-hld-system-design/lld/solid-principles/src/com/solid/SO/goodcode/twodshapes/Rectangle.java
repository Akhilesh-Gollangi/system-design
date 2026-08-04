package com.solid.SO.goodcode.twodshapes;

import com.solid.SO.goodcode.Shape2D;

public class Rectangle implements Shape2D {
    @Override
    public double calculateArea(double dimension1, double dimension2) {
        return dimension1 * dimension2;
    }
}
