package com.abstraction;

public class Main {

    public static void main(String[] args) {
        // Sim sim = new Sim();
        // We cannot create an object of an abstract class.
        // An abstract class is incomplete because it may contain abstract methods.

        // We achieve abstraction using inheritance and runtime polymorphism.
        // Abstraction means hiding the implementation details from the caller.

        Sim sim = new Airtel();
        sim.calling();

        /*
            compile time when we go to calling method which goes to sim class calling method,
            which has only method. it donot have any implemenation at Sim class which means we are hiding.
            this we are hiding from caller class Main which is called abstraction
         */

        /*
         * At compile time, the reference type is Sim.
         * So, we only know that a calling() method exists.
         * We do not know or care about its implementation.
         *
         * The implementation is hidden from the Main class.
         * This is called abstraction.
         */

        //At run time based on the type of the object it will go to that
        // particaular overriden method like Airtel or Jio
        // so overriden implementation is hidden


        Sim sim1 = new Jio();
        sim1.calling();


        /*
            The purpose of this is decoupling (minmal changes)
            Just by changing type of the object
         */
        CallerManagement callerManagement = new CallerManagement();
        callerManagement.call(new Airtel());
        callerManagement.call(new Jio());

        //we can create abstract method in 2 ways
            //abstract classes
            //interfaces


    }
}
