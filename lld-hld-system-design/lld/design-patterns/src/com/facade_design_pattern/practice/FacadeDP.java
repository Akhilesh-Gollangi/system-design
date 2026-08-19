package com.facade_design_pattern.practice;

public class FacadeDP {

    private PayementService payementService;
    private FraudService fraudService;
    private PaymentGatewayService paymentGatewayService;
    private NotificationService notificationService;

    public FacadeDP(PayementService payementService, FraudService fraudService, PaymentGatewayService paymentGatewayService, NotificationService notificationService) {
        this.payementService = payementService;
        this.fraudService = fraudService;
        this.paymentGatewayService = paymentGatewayService;
        this.notificationService = notificationService;
    }

    // this good way
    // instead of repeat those step they call this method
    public void checkOut(Order order) {
        payementService.validate(order);
        if(fraudService.isRisky(order)) {
            throw new RuntimeException("Payment Blocked");
        }
        paymentGatewayService.paymentProcess(order.getAmount());
        notificationService.notify(order);
    }
}
