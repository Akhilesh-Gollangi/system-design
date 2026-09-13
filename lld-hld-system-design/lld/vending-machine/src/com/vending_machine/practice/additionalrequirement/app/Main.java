package com.vending_machine.practice.additionalrequirement.app;

import com.vending_machine.practice.additionalrequirement.common.PaymentMethod;
import com.vending_machine.practice.additionalrequirement.facade.VendingMachineFacade;
import com.vending_machine.practice.additionalrequirement.machine.Slot;
import com.vending_machine.practice.additionalrequirement.machine.VendingMachine;
import com.vending_machine.practice.additionalrequirement.machine.exception.SlotUnAvaialbleException;
import com.vending_machine.practice.additionalrequirement.payment.exception.InValidPaymentException;
import com.vending_machine.practice.additionalrequirement.trasaction.Transaction;
import com.vending_machine.practice.additionalrequirement.trasaction.TransactionManager;

// Additional requirements
// 1. support new Special card payment type
// 2. introduce Reward for payment
// 3. releaseChange and receiveCash should happen only for cash, not for other payment methods
public class Main {

    private static final VendingMachine VENDING_MACHINE = VendingMachine.getInstance();

    public static void main(String[] args) {

        //add slots and products in machine
        VENDING_MACHINE.addSlot(new Slot("A1", "Chips", 2.50, 10));
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


        // additional requirement
        facade.selectSlot("A1");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.SPECIAL_CARD,10.00));

        // For UPI payment i want cash back
        facade.selectSlot("A1");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.UPI_REWARD,2.25));

        //releaseChange and receivecash for only cashPayment
        System.out.println("Amount in change Reserve: "+ facade.amountInReserve());
        facade.selectSlot("A1");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.UPI_REWARD,2.25));
        System.out.println("Amount in change Reserve: "+ facade.amountInReserve());
        // AMOUNT RESEVER WONOT CHANGE WHEN WE MAKE PAYMENT OTHER THAN CASH

        facade.selectSlot("A1");
        printIfCompleted(facade, facade.makePayment(PaymentMethod.CASH,3.00));
        System.out.println("Amount in change Reserve: "+ facade.amountInReserve());
        // RESERVE WILL CHANGE ONLY FOR CASH PAYMENT







    }

    private static void printIfCompleted (VendingMachineFacade facade, Transaction transaction){
        if (transaction != null) {
            System.out.println("purchase complete: " + transaction.getProductName() + ", change returned: " + transaction.getChangeGiven());
        } else {
            System.out.println("payment incomplete, amount still owed: " + facade.amountToPay());
        }
    }


}
