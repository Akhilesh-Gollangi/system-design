package com.vending_machine.practice.facade;

import com.vending_machine.practice.common.PaymentMethod;
import com.vending_machine.practice.machine.Slot;
import com.vending_machine.practice.machine.VendingMachine;
import com.vending_machine.practice.machine.exception.InSufficientReserve;
import com.vending_machine.practice.machine.state.DispenseState;
import com.vending_machine.practice.machine.state.IdleState;
import com.vending_machine.practice.machine.state.UnAvailableState;
import com.vending_machine.practice.payment.IPaymentStrategy;
import com.vending_machine.practice.payment.PaymentStrategyFactory;
import com.vending_machine.practice.service.InventoryReportService;
import com.vending_machine.practice.trasaction.Transaction;
import com.vending_machine.practice.trasaction.TransactionManager;

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

    public Transaction completeTransaction(PaymentMethod paymentMethod,Slot slot) {
        double amountReceived = machine.getPendingPurchase().getAmountReceived();
        double change = amountReceived - slot.getPrice();

        if(!machine.canMakeChange(change)) {
            machine.resetPurchase();
            machine.setState(IdleState.getInstance());
            throw new InSufficientReserve("Don't have enough reserve to give change");
        }

        machine.setState(DispenseState.getInstance());

        slot.dispense();

        machine.releaseChange(change);
        machine.receivedCash(amountReceived);//we are adding amount to reserver for now
        // in future this should happen only for cash



        Transaction transaction =  machine.getPendingPurchase().completeTransaction(paymentMethod,
                amountReceived,change,System.currentTimeMillis());
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
}
