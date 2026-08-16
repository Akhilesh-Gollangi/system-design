package com.factor_design_pattern.notes.abstract_factory_design_pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Furnishing a Modern-themed room:");
        FurnitureStore modernStore = new FurnitureStore(new ModernFurnitureFactory());
        modernStore.furnishRoom();

        System.out.println("\nFurnishing a Victorian-themed room:");
        FurnitureStore victorianStore = new FurnitureStore(new VictorianFurnitureFactory());
        victorianStore.furnishRoom();
    }
}
