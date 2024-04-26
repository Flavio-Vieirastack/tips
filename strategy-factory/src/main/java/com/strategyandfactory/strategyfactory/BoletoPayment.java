package com.strategyandfactory.strategyfactory;

public class BoletoPayment implements Payment{
    @Override
    public void makePayment() {
        System.out.println("Pagando com BOLETO");
    }
}
