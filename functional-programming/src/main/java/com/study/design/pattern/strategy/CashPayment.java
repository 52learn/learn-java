package com.study.design.pattern.strategy;

import java.util.function.IntFunction;

public class CashPayment implements IntFunction<Integer> {
    @Override
    public Integer apply(int value) {
        System.out.println(getClass().getName()+" amount: "+value);
        return value;
    }
}
