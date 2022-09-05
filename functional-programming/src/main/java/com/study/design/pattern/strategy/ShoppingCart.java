package com.study.design.pattern.strategy;

import java.util.function.IntFunction;

public class ShoppingCart {
    private int amount;
    public ShoppingCart(int amount){
        this.amount = amount;
    }
    public Integer pay(IntFunction<Integer> payment){
        return payment.apply(amount);
    }

}
