package com.vending_machine.practice.additionalrequirement.payment;

import com.vending_machine.practice.additionalrequirement.machine.VendingMachine;
import com.vending_machine.practice.additionalrequirement.payment.exception.InValidPaymentException;

public class CashPayment implements IPaymentStrategy {

    @Override
    public double process(double amount) {
        if(amount<=0) {
            throw new InValidPaymentException("Invalid cash Entered into machine");
        }
        return amount;
    }

//    public void releaseChange(VendingMachine machine, double change) {
//        machine.releaseChange(change);
//    }
//
//    public void receivedCash(VendingMachine machine, double amountReceived) {
//        machine.receivedCash(amountReceived);
//    }

    public boolean doesAffectReserveCash() {
        return true;
    }

}
