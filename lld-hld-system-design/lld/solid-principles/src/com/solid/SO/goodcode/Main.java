package com.solid.SO.goodcode;

import com.solid.SO.goodcode.threedshapes.Cube;
import com.solid.SO.goodcode.twodshapes.Circle;
import com.solid.SO.goodcode.twodshapes.Rectangle;
import com.solid.SO.goodcode.twodshapes.Triangle;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ShapeCalculator calculator = new ShapeCalculator();

        HashMap<String, Shape2D> shape2DHashMap = new HashMap<>();
        shape2DHashMap.put("circle", new Circle());
        shape2DHashMap.put("rectangle", new Rectangle());
        shape2DHashMap.put("triangle", new Triangle());

        HashMap<String, Shape3D> shape3DHashMap = new HashMap<>();
        shape3DHashMap.put("cube", new Cube());
        shape3DHashMap.put("Sphere",new Cube());



        while (true) {
            System.out.println("\nWhat do you want to calculate?");
            System.out.println("1. Area");
            System.out.println("2. Volume");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            if (choice == 1) {
                System.out.println("Enter shape (circle / rectangle / triangle): ");
                String shape = scanner.next();

                System.out.print("Enter dimension 1: ");
                double d1 = scanner.nextDouble();

                System.out.print("Enter dimension 2 (enter 0 if not needed): ");
                double d2 = scanner.nextDouble();

                double area = calculator.areaCalculator(shape2DHashMap.get(shape),d1, d2);
                System.out.println("Area: " + area);

            } else if (choice == 2) {
                System.out.println("Enter shape (Sphere / cube): ");
                String shape = scanner.next();

                System.out.print("Enter dimension: ");
                double d1 = scanner.nextDouble();

                double volume = calculator.volumeCalculator(shape3DHashMap.get(shape),d1);
                System.out.println("Volume: " + volume);
            }
        }

        scanner.close();
    }
}