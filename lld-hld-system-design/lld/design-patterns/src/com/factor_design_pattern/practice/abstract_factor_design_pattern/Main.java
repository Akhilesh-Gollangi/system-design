package com.factor_design_pattern.practice.abstract_factor_design_pattern;

// This is also a factory design pattern
// Until now in simple factory design pattern when we send some param based on the param, it returns the object
// In Factory method, where classes are responsbile for creating the objects
// But here in abstract factory pattern it produces set objects of similar types of traits, when we enforce something we use this pattern


// Use Case : We have chair of two types(modern, victorian) and sofa as well(modern, victoria)
// we want either both of them modren or both of them are vicotria
public class Main {

    public static void main(String[] args) {
        // As client we can communicate to Furniture store
        // Furniture store is responsbile for get object Object of the similar type
        // Here we are design in such way that Furniture store always get chair and sofa of same type
        // It is impossible to get chair of victorian and sofa of modern viceversa
        // In this we restrict and getting group of object of similar type and traits
        // when we want grp of object then we can use this pattern

        FurnitureFactory modernFactory = new ModernFurnitureFactory();
        FurnitureStore furnitureStore = new FurnitureStore();
        furnitureStore.setFurnitureFactory(modernFactory);
        furnitureStore.furnish();

        FurnitureFactory furnitureStore1 = new VictorianFurnitureFactory();
        FurnitureStore furnitureStore2 = new FurnitureStore(furnitureStore1);
        furnitureStore2.furnish();
    }


}
