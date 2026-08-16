package com.factor_design_pattern.practice.simple_factory;

//Factory design pattern is a creational design pattern
// which will provide function to get object, that function has logic to create object
// when we have some logic to create object we use factory design pattern
// It help client to reuse instead of repeat code again
// if there no logic we can just do new className();


// there are 3types of Factory Design patterns
// 1. Simple Factory
// 2. Factory Method
// 3. Abstract Method


// we will discuss Simple Factory
// In game we have different level in each level we have different level enemies
// so we use factory to create enemy object based on the level right
public class Main {

    public static void main(String[] args) {

        Level level = new Level();
        level.start("LEVEL1");
        level.start("LEVEL2");
        level.start("LEVEL3");

        // the main problem here is as number of level increase we have modifiy existing code
        // and it is not scalable

        // we can use simple factory method when we have less than 3-4 object and simpler logic
        // if we have more object and complex logic and in future we will get need new object then
        // factory should be used

        // we will discuss with same example but it will scale to n numbers of classes

    }
}
