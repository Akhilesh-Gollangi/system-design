package com.template_design_pattern.usecase.practice;

public abstract class PaymentProcessor {

    public abstract IPayment createPayment();

    // I have intentinal keep some method as private
    // because there is no need of overiding these as it will be same in all the child classes
    private void validation(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount must be greater than 0");
        }
        System.out.println("Successfully validated");
    }

    public boolean requiredOTPVerification() {
        return true;
    }

    private boolean OTPVerification() {
        return true;
    }

    private void logTransaction(double amount) {
        System.out.println("We have done trasaction of amount : " + amount);
    }

    public void processOrder(double amount) {
        validation(amount);
        if (requiredOTPVerification()) {
            if (!OTPVerification()) {
                throw new IllegalArgumentException("OTP is invalid");
            }
            System.out.println("OTP verfication completed");
        }
        IPayment payment = createPayment();

        payment.pay(amount);

        logTransaction(amount);

    }
}
