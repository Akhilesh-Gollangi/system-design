package com.decorator_design_pattern.assignment.practice.decorator_with_pament;

//now this class become context class for FeeDecorator
// which take DI and perform operation
public class FeeDecorator extends BaseDecorator {
    private IFeeStretegy fee;

    public FeeDecorator(IPayment payment, IFeeStretegy fee) {
        super(payment);
        this.fee = fee;
    }

    @Override
    public void pay() {
        fee.feeDeduction();
        payment.pay();
    }
}


