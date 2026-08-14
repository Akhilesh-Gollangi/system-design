package com.factor_design_pattern.factory_method.factory_of_levels;

//Factory Design pattern is creational design pattern
// define an  interface for creating the objects,but let the subclass decide which object to be  intiated

// we will discuss factory method in it
// In game we have different level in each level we have different level enemies
// so we use factory to create enemy object based on the level right
public class Main {

    public static void main(String[] args) {

        // we have done this with factory method
        // where child class decide which object to intiated
        // so even we get n number of level
        // we will add enemy x  by implement Ienemy and levelx will extend level class
        // there will no change in exisiting code.
        // like this we can add n number of levels which is scalable and maintainable
        Level level = new Level1();
        level.start();

        Level level1 = new Level2();
        level1.start();

        Level level2 = new Level3();
        level2.start();



    }
}
