package com.vending_machine.practice.intialrequirement.machine.state;

import com.vending_machine.practice.intialrequirement.machine.Slot;
import com.vending_machine.practice.intialrequirement.machine.VendingMachine;
import com.vending_machine.practice.intialrequirement.machine.exception.InValidMachineStateException;
import com.vending_machine.practice.intialrequirement.machine.exception.SlotUnAvaialbleException;

public class IdleState implements IState{

    private static final IdleState instance = new IdleState();

    public static IdleState getInstance() {
        return instance;
    }

    private IdleState() {

    }


    @Override
    public void selectSlot(VendingMachine machine, String slotId) {
        Slot slot = machine.findSlotById(slotId);
        if(slot == null || !slot.hasStock()) {
            throw new SlotUnAvaialbleException("Slot Id not found or Product is out of stock");
        }
        machine.startPurchase(slot);
        machine.setState(AwaitingPaymentState.getInstance());
    }

    @Override
    public void makePayment(VendingMachine machine, double amount) {
        throw new InValidMachineStateException("Select product first before making payment");
    }

    @Override
    public void cancel(VendingMachine machine) {
        System.out.println("Nothing to Cancel, Machine is Idle State");
    }
}
