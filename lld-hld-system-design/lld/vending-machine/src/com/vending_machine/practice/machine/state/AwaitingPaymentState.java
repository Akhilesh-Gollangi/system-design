package com.vending_machine.practice.machine.state;

import com.vending_machine.practice.machine.VendingMachine;
import com.vending_machine.practice.machine.exception.InValidMachineStateException;

public class AwaitingPaymentState implements IState {
    private static final AwaitingPaymentState instance = new AwaitingPaymentState();

    public static AwaitingPaymentState getInstance() {
        return instance;
    }

    private AwaitingPaymentState() {

    }

    @Override
    public void selectSlot(VendingMachine machine, String slotId) {
        throw new InValidMachineStateException("Slot is already, cannot select slot again");
    }

    @Override
    public void makePayment(VendingMachine machine, double amount) {
        machine.getPendingPurchase().addAmountReceived(amount);
        System.out.println("Amount Received to purchase the product: " + amount);
    }

    @Override
    public void cancel(VendingMachine machine) {
        machine.resetPurchase();
        machine.setState(IdleState.getInstance());
    }
}
