package com.solid.LID.GOOD_LID_SO_FIXED.calculator;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape2D;

import java.util.ArrayList;
import java.util.List;

public class AreaCalculator {

    private final List<IShape2D> shapes;

    public AreaCalculator(List<IShape2D> shape2D) {
        shapes = new ArrayList<>(shape2D);
    }

    public double calculateTotalArea() {
        double total = 0;
        for (IShape2D shape : shapes) {
            total += shape.getArea(); // runtime polymorphism
        }
        return total;
    }
}