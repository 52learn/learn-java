package com.study.design.pattern.strategy;

public class PaymentMain {
    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart(100);
        shoppingCart.pay(new CashPayment());
        shoppingCart.pay(new CreditPayment());
    }
}
