package com.template_design_pattern.concept;

public class Main {

    public static void main(String[] args) {
        //Without beverage maker function in BevargeMaker class
        // this is just inheritance and overriding of methods

        /*
            With beverage maker function in BevargeMaker class, we have set some receipe which is here
            order of execution of methods.
            If you have kept in child classes, if we get new child classes then again we need add this beverage maker function in child classes.
            So we kept it away from child classes and kept it in parent class. So that we can have a common receipe for all child classes.
            This is called as Template Design Pattern. We have a template of receipe in parent class.
         */

        BevargeMaker coffeeMaker = new CoffeeMaker();
        coffeeMaker.makeBeverage();
        /* when ever parent ref object hold child class then method called always child methods only
           Here coffeeMaker.makeBeverage() whoes makeBeverage is called is BevargeMaker or CoffeeMaker?
           CoffeMaker makeBeverage is called as it inherits from BevargeMaker and it is not overridden in CoffeeMaker class.
           But as we have not overriden we donot have implementation in CoffeMaker, makeBeverage which we get from parent as it inherits.
           Implementaiton is not visible in CoffeMaker as it only inherits but doesnot override.
           So will debugging it goes BevargeMaker makeBeverage() and but the method is from CoffeeMaker class as it is inherited.
        */
    }
}
