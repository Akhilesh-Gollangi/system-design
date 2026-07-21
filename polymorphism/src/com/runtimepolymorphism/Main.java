package com.runtimepolymorphism;

public class Main {
    public static void main(String[] args) {

        //this is simple inheritance

        //Labrador extend Dog
        //doBark method of parent is called
        Labrador labrador = new Labrador();
        labrador.doBark();

        //Pomeranian extend DOg
        // but Pomeranian has it onw implementation
        // here we have overriden parent implementation of that method
        Pomeranian pomeranian = new Pomeranian();
        pomeranian.doBark();


        // this is called runtime polymorphism
        // parent class type ref can hold child type ref
        Dog dog = new Pomeranian();
        dog.doBark();


        // this gives decoupling & code reusability
        // n number of class can use makeSound method
        // so that particular class doBark method is called
        // Decoupling means changes in one class should not affect other classes.
        DogSound dogSound = new DogSound();
        dogSound.makeSound(new Labrador());
    }
}
