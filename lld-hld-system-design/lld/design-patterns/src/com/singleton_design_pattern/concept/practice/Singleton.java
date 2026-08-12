package com.singleton_design_pattern.concept.practice;

// In singleton design pattern
// we are allowing to create only one object
// How is an object is created using constructor so we will make constructor private so now one can create obj
// But our agenda is to create single object so, we provide a method getInstance this is will return the object
// getInstance() returns object, it is accessed by className
// in the method on first time we will create an object and store it some where then return it
// whenever somecalled this method we check whether object is availble then we return it
// Here we didnot discuss multi threading
public class Singleton {

    // why we keep it static is
    // static variable can access in static method directly
    private static Singleton singleton;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if(singleton==null) {
            singleton = new Singleton();
            return  singleton;
        }
        return singleton;
    }
}
