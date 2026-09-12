package com.vending_machine.practice1.machine.state;

import com.vending_machine.practice1.machine.VendingMachine;
import com.vending_machine.practice1.machine.exception.InValidMachineStateException;

public class DispenseState implements IState{

    private static final DispenseState instance = new DispenseState();

    public static DispenseState getInstance() {
        return instance;
    }

    private DispenseState() {

    }

    @Override
    public void selectSlot(VendingMachine machine, String slotId) {
        throw new InValidMachineStateException("Slot is already selected, please wait");
    }

    @Override
    public void makePayment(VendingMachine machine, double amount) {
        throw new InValidMachineStateException("Payment is already selected, please wait");

    }

    @Override
    public void cancel(VendingMachine machine) {
        throw new InValidMachineStateException("Product is Despensing unable to cancel, please wait");

    }
}
