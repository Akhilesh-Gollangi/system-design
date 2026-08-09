package com.template_design_pattern.usecase.notes;

public abstract class PaymentProcessor {

    public abstract IPayment createPayment();

    //validate
    private void validate(double amount){
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be a positive number");
        }
    }

    private void logTransaction(double amount){
        System.out.println("this amount was transacted " + amount);
    }

    public boolean requiresOTPVerification(){
        return true;
    }

    private boolean verifyOTP()
    {
        boolean isCorrect = true;
        return isCorrect;
    }

    // the template in our case which the child must follow
    public void processOrder(double amount){

        //1
        validate(amount);

        //2
        if(requiresOTPVerification()){

            //3
            boolean otpOK = verifyOTP();
            if(!otpOK){
                System.out.println("OTP verification failed");
                return;
            }
        }

        //4
        IPayment payment = createPayment();

        //5
        payment.pay(amount);

        // 6
        logTransaction(amount);

    }


}
