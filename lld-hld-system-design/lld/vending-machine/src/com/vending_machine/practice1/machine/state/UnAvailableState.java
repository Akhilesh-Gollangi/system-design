package com.vending_machine.practice1.machine.state;

import com.vending_machine.practice1.machine.VendingMachine;
import com.vending_machine.practice1.machine.exception.InValidMachineStateException;

public class UnAvailableState implements IState{

    private static final UnAvailableState instance = new UnAvailableState();

    public static UnAvailableState getInstance() {
        return instance;
    }

    private UnAvailableState() {

    }


    @Override
    public void selectSlot(VendingMachine machine, String slotId) {
        throw new InValidMachineStateException("Slot is Empty, product is out of stock");
    }

    @Override
    public void makePayment(VendingMachine machine, double amount) {
        throw new InValidMachineStateException("Cannot Accept payment, product is  out of stock");

    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Nothing to cancel, we are not processing anything");
    }
}
