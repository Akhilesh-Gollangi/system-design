package com.strategy_pattern.concept;

// this is caller class
// In strategy pattern this is known as the client class
public class Main {

    public static void main(String[] args) {
        Child1 child1 = new Child1();
        Child2 child2 = new Child2();
        Child3 child3 = new Child3();

        //Dependency Inversion
        // we are injecting dependency thorogh param with constructor or setter

        // With constructor we can do it only once because in general
        // we create object only once in application
        // this will limit to us to swap between the objects at runtime
        Delegators delegators = new Delegators(child1);
        delegators.process();

        // this is reason we have setters this will allow us to swap objects at run time
        delegators.setParent(child2);
        delegators.process();

        delegators.setParent(child3);
        delegators.process();


        /*
        * What strategy pattern define is
        *
        * It is behavioural design pattern, define group of related algorithms, encapsulate each one in separate class
        * and make them interchange able. It allows alogrithm to be vary independenlty from client class
        * enabling changing of behaviour at runtime without changing existing code.
        *
        */

        /*
            When to use Strategy pattern : when Open close principle is breaking.
            Which means we have multiple if else blocks, the code which is inside ifelse block is alogorithm (group of related algorithms)
            we create class for based on the derving factor which used in if else blocks and move them alogrithm to particular class
            (here we are encapsulate each algorithm in a separate class)
            We have common parent for all these classes which is Interface. parent ref can accept child object
            By this we are allowing Interchanging of childs at runtime

            even we get n number of classes, we just had to new class which implement the parent and develop their own alogorithem
            there is no chnage in the existing code
         */

        /*
            Strategy pattern has these components
            client, context, Strategy Interface, Concerter Stratagies

         *  Client here is Main class which is responsbile for creating objects and calling context class and doing dependency injection
         *  context here is Intermediate class, which delegates the request to particular class based on the type of the objects
            it takes the object in as COnstructor or setter and perform operation (Delegators class)

         * Strategy Interface which is interface enforces consistancy and child should implememt this (Iparent Interface)
         * Concerte Stratagies : these are the actual class which implemented the Strategy Interface (child1,child2,child3)
         */

    }



}
