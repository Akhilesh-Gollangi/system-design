package com.vending_machine.practice.additionalrequirement.service;

public class ChangeService {

    private double reserve;

    public ChangeService(double reserve) {
        this.reserve = reserve;
    }

    public void receivedAmount(double amount) {
        reserve += amount;
    }

    public boolean canMakeChange(double amount) {
        return reserve>=amount;
    }

    public void releaseChange(double amount) {
        this.reserve-=amount;
    }

    public double getReserve() {
        return reserve;
    }
}
