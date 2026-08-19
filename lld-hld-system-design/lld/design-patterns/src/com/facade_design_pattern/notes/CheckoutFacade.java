package com.facade_design_pattern.notes;

public class CheckoutFacade {

    private PaymentValidator validator;
    private FraudCheckService fraudCheck;
    private PaymentGateway gateway;
    private NotificationService notifier;

    public CheckoutFacade() {
        this.validator = new PaymentValidator();
        this.fraudCheck = new FraudCheckService();
        this.gateway = new PaymentGateway();
        this.notifier = new NotificationService();
    }

    public void checkout(Order order) {
        validator.validate(order);

        if (fraudCheck.isRisky(order)) {
            throw new RuntimeException("Payment blocked");
        }

        gateway.charge(order.getAmount());
        notifier.sendReceipt(order);
    }
}
