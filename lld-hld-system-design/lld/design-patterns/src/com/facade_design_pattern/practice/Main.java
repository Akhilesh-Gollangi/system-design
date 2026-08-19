package com.facade_design_pattern.practice;

public class Main {

    public static void main(String[] args) {
        Order order = new Order(1,"Ak",10.0);
        PayementService payementService = new PayementService();
        payementService.validate(order);

        FraudService fraudService = new FraudService();
        if(fraudService.isRisky(order)) {
            throw new RuntimeException("Payment Blocked");
        }

        PaymentGatewayService paymentGatewayService = new PaymentGatewayService();
        paymentGatewayService.paymentProcess(order.getAmount());

        NotificationService notificationService = new NotificationService();
        notificationService.notify(order);

        //ABOVE IS THE BAD WAY OF DOING THINGS

        //instead of that we will maintian function which will do all these things
        // so we can reuse whenever we need it
        FacadeDP dp = new FacadeDP(payementService,fraudService,paymentGatewayService,notificationService);
        dp.checkOut(order);


    }
}
