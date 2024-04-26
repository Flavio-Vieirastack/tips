package com.strategyandfactory.strategyfactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentsController {

    @Autowired
    private PaymentFactory paymentFactory;

    @GetMapping
    public void payments(@RequestParam PaymentType paymentType) {
        paymentFactory.pay(paymentType);
    }
}
