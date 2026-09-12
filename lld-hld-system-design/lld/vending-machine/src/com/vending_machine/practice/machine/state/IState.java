package com.vending_machine.practice.machine.state;

import com.vending_machine.practice.machine.VendingMachine;

public interface IState {

    void selectSlot(VendingMachine machine, String slotId);

    void makePayment(VendingMachine machine, double amount);

    void cancel(VendingMachine machine);
}
