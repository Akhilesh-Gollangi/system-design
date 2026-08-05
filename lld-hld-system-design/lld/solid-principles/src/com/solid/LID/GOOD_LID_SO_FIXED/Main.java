package com.solid.LID.GOOD_LID_SO_FIXED;

import com.solid.LID.GOOD_LID_SO_FIXED.calculator.AreaCalculator;
import com.solid.LID.GOOD_LID_SO_FIXED.calculator.PerimeterCalculator;
import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape2D;
import com.solid.LID.GOOD_LID_SO_FIXED.interfaces.IShape3D;
import com.solid.LID.GOOD_LID_SO_FIXED.shapes.Circle;
import com.solid.LID.GOOD_LID_SO_FIXED.shapes.Cube;
import com.solid.LID.GOOD_LID_SO_FIXED.shapes.Line;
import com.solid.LID.GOOD_LID_SO_FIXED.shapes.Rectangle;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWhat do you want to do?");
            System.out.println("1. Calculate Total Area");
            System.out.print("2. Calculate Perimeter");
            System.out.println("3, Volume Calculation");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice == 1) {
                List<IShape2D> shapes = List.of(
                        new Circle(5),
                        new Rectangle(4, 6)
                );
                AreaCalculator calculator = new AreaCalculator(shapes);
                double totalArea = calculator.calculateTotalArea();
                System.out.println("Total Area: " + totalArea);
            } else if (choice == 2) {
                PerimeterCalculator calculator = new PerimeterCalculator(
                        List.of(new Line(10))
                        , List.of(
                        new Circle(5),
                        new Rectangle(4, 6)
                ));
                double totalPerimeter = calculator.calculateTotalPerimeter();
                System.out.println("Total Perimeter: " + totalPerimeter);
            } else if (choice == 3) {
                List<IShape3D> shapes3D = List.of(
                        new Cube(3)
                );
                double totalVolume = 0;
                for (IShape3D shape : shapes3D) {
                    totalVolume += shape.getVolume();
                }
                System.out.println("Total Volume: " + totalVolume);


            }
        }

        scanner.close();
    }
}