package com.strategyandfactory.strategyfactory;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class PaymentFactory {
    public void pay(PaymentType paymentType) {
        var payments = new HashMap<PaymentType, Payment>();
        payments.put(PaymentType.BOLETO, new BoletoPayment());
        payments.put(PaymentType.PIX, new PixPayment());
        payments.get(paymentType).makePayment();
    }
}
