package com.adaptor_design_pattern.notes;

public class Main {
    public static void main(String[] args) {

        Processor cardProcessor = new Processor(new Card());
        cardProcessor.process();

        Processor upiProcessor = new Processor(new UPI());
        upiProcessor.process();

        // CashPayment is incompatible with Processor since it doesn't implement IPayment
        // wrap it with CashPaymentAdapter to make it compatible, without changing CashPayment itself
        CashPayment cashPayment = new CashPayment();
        Processor cashProcessor = new Processor(new CashPaymentAdapter(cashPayment));
        cashProcessor.process();
    }
}
