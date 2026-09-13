package com.vending_machine.practice.additionalrequirement.payment;

import com.vending_machine.practice.additionalrequirement.common.PaymentMethod;

import java.util.HashMap;
import java.util.Map;

public class PaymentStrategyFactory {

    private static final Map<PaymentMethod, IPaymentStrategy> paymentStrategyMap= new HashMap<>();

    static {
        paymentStrategyMap.put(PaymentMethod.CARD,new CardPayment());
        paymentStrategyMap.put(PaymentMethod.CASH,new CashPayment());
        paymentStrategyMap.put(PaymentMethod.UPI,new UPIPayment());
    }

    public static IPaymentStrategy paymentStrategy(PaymentMethod paymentMethod) {
        return paymentStrategyMap.get(paymentMethod);
    }
}
