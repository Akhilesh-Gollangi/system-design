package com.solid.LID.GOOD_LID_SO_FIXED.calculator;

import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape1D;
import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape2D;

import java.util.List;

public class PerimeterCalculator {

    private final List<IShape1D> shapes;

    private final List<IShape2D> shapes2D;

    // Constructor to initialize the PerimeterCalculator with lists of 1D and 2D shapes
    // this is called dependency injection, we are injecting the dependencies of the class through the constructor
    // this class is donot create the objects of the shapes, it is only responsible for calculating the perimeter of the shapes
    // higher level modules should not depend on lower level modules, both should depend on abstractions. This is called dependency inversion principle.
    public PerimeterCalculator(List<IShape1D> shape1D, List<IShape2D> shape2D) {
        shapes = shape1D;
        shapes2D = shape2D;
    }

    public double calculateTotalPerimeter() {
        double total = 0;
        for (IShape1D shape : shapes) {
            total += shape.getPerimeter(); // runtime polymorphism
        }
        for (IShape2D shape : shapes2D) {
            total += shape.getPerimeter(); // runtime polymorphism
        }
        return total;
    }

}
