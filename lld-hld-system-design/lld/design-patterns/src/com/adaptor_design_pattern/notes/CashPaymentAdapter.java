package com.adaptor_design_pattern.notes;

public class CashPaymentAdapter implements IPayment {

    private CashPayment cashPayment;

    public CashPaymentAdapter(CashPayment cashPayment) {
        this.cashPayment = cashPayment;
    }

    @Override
    public void pay() {
        cashPayment.makePayment();
    }
}
