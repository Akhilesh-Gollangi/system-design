package com.vending_machine.practice.additionalrequirement.payment;

import com.vending_machine.practice.additionalrequirement.machine.VendingMachine;

public interface IPaymentStrategy {

    double process(double amount);


//    // we want this only in cash, but if it is abstract method i have to repeat it all class
//    // to avoid that i will keep empty body here, how want to change, can make there changes in their classes
//    // but interface doesnot allow implementation even empty body is implementation
//    // so we make it default
//    default void releaseChange(VendingMachine machine, double change) {
//
//    }
//
//    // we want this only in cash, but if it is abstract method i have to repeat it all class
//    // to avoid that i will keep empty body here, how want to change, can make there changes in their classes
//    // but interface doesnot allow implementation even empty body is implementation
//    // so we make it default
//    default void receivedCash(VendingMachine machine, double amountReceived) {
//
//    }

    // we want this only in cash, but if it is abstract method i have to repeat it all class
    // to avoid that i will keep empty body here, how want to change, can make there changes in their classes
    // but interface doesnot allow implementation even empty body is implementation
    // so we make it default
    default boolean doesAffectReserveCash() {
        return false;
    }
}
