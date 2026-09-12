package com.vending_machine.practice1.facade;

import com.vending_machine.practice1.common.PaymentMethod;
import com.vending_machine.practice1.machine.Slot;
import com.vending_machine.practice1.machine.VendingMachine;
import com.vending_machine.practice1.machine.exception.InSufficientReserve;
import com.vending_machine.practice1.machine.state.DispenseState;
import com.vending_machine.practice1.machine.state.IdleState;
import com.vending_machine.practice1.machine.state.UnAvailableState;
import com.vending_machine.practice1.payment.IPaymentStrategy;
import com.vending_machine.practice1.payment.PaymentStrategyFactory;
import com.vending_machine.practice1.service.InventoryReportService;
import com.vending_machine.practice1.trasaction.Transaction;
import com.vending_machine.practice1.trasaction.TransactionManager;

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

        machine.releaseChange(change);
        machine.receivedCash(amountReceived);//we are adding amount to reserver for now
        // in future this should happen only for cash

        machine.setState(DispenseState.getInstance());
        slot.dispense();

        Transaction transaction =  machine.getPendingPurchase().completeTransaction(slot.getSlotId(),
                slot.getProductName(),
                slot.getPrice(),paymentMethod,amountReceived,change,System.currentTimeMillis());
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
