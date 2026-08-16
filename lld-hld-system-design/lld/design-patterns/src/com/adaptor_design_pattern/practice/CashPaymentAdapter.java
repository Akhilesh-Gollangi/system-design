package com.adaptor_design_pattern.practice;

public class CashPaymentAdapter implements IPayment{

    private CashPayment cashPayment;

    public CashPaymentAdapter(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    public void setCashPayment(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    public CashPaymentAdapter() {
    }

    @Override
    public void pay() {
        cashPayment.makePayment();
    }
}
