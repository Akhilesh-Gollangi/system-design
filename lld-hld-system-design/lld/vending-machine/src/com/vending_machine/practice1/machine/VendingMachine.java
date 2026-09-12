package com.vending_machine.practice1.machine;

import com.vending_machine.practice1.machine.exception.SlotNotFoundException;
import com.vending_machine.practice1.machine.state.IState;
import com.vending_machine.practice1.machine.state.IdleState;
import com.vending_machine.practice1.service.ChangeService;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private static final VendingMachine instance = new VendingMachine();

    private List<Slot> slots;

    private IState state = IdleState.getInstance();

    // The cash in the vending machine should not update if you are paying via UPI or card,
    // because then the cash is going into the bank account of the merchant
    // and not into the amount reservoir of the vending machine.
    private ChangeService changeService;

    private PendingPurchase pendingPurchase;


    public static VendingMachine getInstance() {
        return instance;
    }

    private VendingMachine() {
        this.slots = new ArrayList<>();
        this.changeService = new ChangeService(0);
    }

    public IState getState() {
        return state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    public List<Slot> getSlots() {
        return slots;
    }

    public Slot findSlotById(String id) {
        for (Slot slot : slots) {
            if (slot.getSlotId().equals(id)) {
                return slot;
            }
        }
        return null;
    }

    public void startPurchase(Slot slot) {
        this.pendingPurchase = new PendingPurchase(slot);
    }

    public PendingPurchase getPendingPurchase() {
        return pendingPurchase;
    }

    public void resetPurchase() {
        this.pendingPurchase = null;
    }

    public boolean canMakeChange(double amount) {
        return changeService.canMakeChange(amount);
    }

    public void releaseChange(double amount) {
        changeService.releaseChange(amount);
    }

    //this will apply only for cash in future, as change from vendormachine come from cashreserve
    // for UPI and card we will give back using bank
    public void receivedCash(double amount) {
        changeService.receivedAmount(amount);
    }

    public void selectSlot(String id) {
        state.selectSlot(this, id);
    }

    public void makePayment(double amount) {
        state.makePayment(this, amount);
    }

    public void cancel() {
        state.cancel(this);
    }


}
