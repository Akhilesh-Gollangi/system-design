package com.vending_machine.practice.additionalrequirement.facade;

import com.vending_machine.practice.additionalrequirement.common.PaymentMethod;
import com.vending_machine.practice.additionalrequirement.machine.Slot;
import com.vending_machine.practice.additionalrequirement.machine.VendingMachine;
import com.vending_machine.practice.additionalrequirement.machine.exception.InSufficientReserve;
import com.vending_machine.practice.additionalrequirement.machine.state.DispenseState;
import com.vending_machine.practice.additionalrequirement.machine.state.IdleState;
import com.vending_machine.practice.additionalrequirement.machine.state.UnAvailableState;
import com.vending_machine.practice.additionalrequirement.payment.IPaymentStrategy;
import com.vending_machine.practice.additionalrequirement.payment.PaymentStrategyFactory;
import com.vending_machine.practice.additionalrequirement.service.InventoryReportService;
import com.vending_machine.practice.additionalrequirement.trasaction.Transaction;
import com.vending_machine.practice.additionalrequirement.trasaction.TransactionManager;

//what client can do
//selectslot, makepayment and cancel
// Client communicates with this class
public class VendingMachineFacade {

    private static final VendingMachine machine = VendingMachine.getInstance();

    private final InventoryReportService inventoryReportService = new InventoryReportService();
    private final TransactionManager transactionManager;

    public VendingMachineFacade(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }


    public void selectSlot(String id) {
        machine.selectSlot(id);
    }

    public Transaction makePayment(PaymentMethod paymentMethod, double amount) {
        IPaymentStrategy paymentStrategy = PaymentStrategyFactory.paymentStrategy(paymentMethod);
        double credited = paymentStrategy.process(amount);

        machine.makePayment(credited);

        Slot slot = machine.getPendingPurchase().getSlot();
        if (machine.getPendingPurchase().getAmountReceived() >= slot.getPrice()) {
            return completeTransaction(paymentMethod, slot);
        }
        return null;
    }

    public Transaction completeTransaction(PaymentMethod paymentMethod, Slot slot) {
        double amountReceived = machine.getPendingPurchase().getAmountReceived();
        double change = amountReceived - slot.getPrice();

        if (!machine.canMakeChange(change)) {
            machine.resetPurchase();
            machine.setState(IdleState.getInstance());
            throw new InSufficientReserve("Don't have enough reserve to give change");
        }

        machine.setState(DispenseState.getInstance());

        slot.dispense();


//        machine.releaseChange(change);
//        machine.receivedCash(amountReceived);//we are adding amount to reserver for now
//        // in future this should happen only for cash

        // in simple way we can do just condition check
//        if (paymentMethod == PaymentMethod.CASH || something) {
//            machine.releaseChange(change);
//            machine.receivedCash(amountReceived);
//        }
        // but in future someone need this then we can modify in same if conditon with OR
        // so we are modifying condition which is not good


        // As this will change it's behaviour based on cash, card, UPI, we will strategy here
//        IPaymentStrategy paymentStrategy = PaymentStrategyFactory.paymentStrategy(paymentMethod);
//        paymentStrategy.releaseChange(machine, change);
//        paymentStrategy.receivedCash(machine,amountReceived);

        // This is working, but there is no need of IPaymentStrategy to know about machine and change
        // but we can implement it clean way like

        IPaymentStrategy paymentStrategy = PaymentStrategyFactory.paymentStrategy(paymentMethod);
        if (paymentStrategy.doesAffectReserveCash()) {
            machine.releaseChange(change);
            machine.receivedCash(amountReceived);
        }

        // we are using if here which means OCP is breaking, you think like that
        // but are we really breaking, No, if any new payment needs this then that class will extend
        // and implement the method, which it is not open for modification
        // it is open for extenesion
        // Design pattern donot said donot use if else, use it extensable way


        Transaction transaction = machine.getPendingPurchase().completeTransaction(paymentMethod,
                amountReceived, change, System.currentTimeMillis());
        transactionManager.save(transaction);

        machine.resetPurchase();
        machine.setState(inventoryReportService.hasStock(machine.getSlots()) ? IdleState.getInstance()
                : UnAvailableState.getInstance());

        return transaction;
    }

    public void cancel() {
        machine.cancel();
    }

    public double amountToPay() {
        return machine.getPendingPurchase().amountToPay();
    }

    public double amountInReserve() {
        return machine.amountInReserve();
    }
}
