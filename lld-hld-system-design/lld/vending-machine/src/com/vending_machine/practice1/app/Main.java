package com.vending_machine.practice1.app;

import com.vending_machine.practice1.common.PaymentMethod;
import com.vending_machine.practice1.facade.VendingMachineFacade;
import com.vending_machine.practice1.machine.Slot;
import com.vending_machine.practice1.machine.VendingMachine;
import com.vending_machine.practice1.machine.exception.SlotUnAvaialbleException;
import com.vending_machine.practice1.payment.exception.InValidPaymentException;
import com.vending_machine.practice1.trasaction.Transaction;
import com.vending_machine.practice1.trasaction.TransactionManager;

public class Main {

    private static final VendingMachine VENDING_MACHINE = VendingMachine.getInstance();

    public static void main(String[] args) {

        //add slots and products in machine
        VENDING_MACHINE.addSlot(new Slot("A1", "Chips", 2.50, 3));
        VENDING_MACHINE.addSlot(new Slot("A2", "Soda", 1.75, 2));
        VENDING_MACHINE.addSlot(new Slot("A3", "Candy Bar", 6.00, 1));
        VENDING_MACHINE.receivedCash(50);



        TransactionManager transactionManager = new TransactionManager();
        VendingMachineFacade facade = new VendingMachineFacade(transactionManager);
        

        facade.selectSlot("A1");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.CASH,3.00));

        facade.selectSlot("A2");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.CASH,1.00));
        printIfCompleted(facade, facade.makePayment(PaymentMethod.CASH,0.75));

        try {
            facade.selectSlot("A3");
            facade.makePayment(PaymentMethod.CARD, 3.00);
        } catch (InValidPaymentException e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        facade.cancel();

        facade.selectSlot("A3");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.CARD,6.00));

        try {
            facade.selectSlot("A3");
        } catch (SlotUnAvaialbleException e) {
            System.out.println("Expected failure: " + e.getMessage());
        }




    }

    private static void printIfCompleted (VendingMachineFacade facade, Transaction transaction){
        if (transaction != null) {
            System.out.println("purchase complete: " + transaction.getProductName() + ", change returned: " + transaction.getChangeGiven());
        } else {
            System.out.println("payment incomplete, amount still owed: " + facade.amountToPay());
        }
    }

    //if client cancelled how would you return amount to user
    // recieveCash should be for cash only for other it will bank
}
