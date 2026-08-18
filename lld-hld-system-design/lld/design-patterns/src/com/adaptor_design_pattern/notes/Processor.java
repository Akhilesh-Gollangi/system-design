package com.adaptor_design_pattern.notes;

public class Processor {

    private IPayment ip;

    public Processor(IPayment ip) {
        this.ip = ip;
    }

    public void process() {
        System.out.println("processing started");
        ip.pay();
        System.out.println("processing completed");
    }
}
