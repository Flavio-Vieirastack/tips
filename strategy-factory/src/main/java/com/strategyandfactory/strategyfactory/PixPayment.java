package com.strategyandfactory.strategyfactory;

public class PixPayment implements Payment{
    @Override
    public void makePayment() {
        System.out.println("Pagando com PIX");
    }
}
