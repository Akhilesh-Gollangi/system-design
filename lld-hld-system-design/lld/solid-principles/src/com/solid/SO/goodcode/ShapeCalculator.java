package com.solid.SO.goodcode;

public class ShapeCalculator {

    public double areaCalculator(Shape2D shape, double dimension1, double dimension2) {
        return shape.calculateArea(dimension1,dimension2);
    }

    public double volumeCalculator(Shape3D shape, double dimension1) {
        return shape.calculateVolume(dimension1);
    }

}
