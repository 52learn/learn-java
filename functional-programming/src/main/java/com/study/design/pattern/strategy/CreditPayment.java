package com.study.design.pattern.strategy;

import java.util.function.IntFunction;

/**
 * 信用卡支付
 */
public class CreditPayment implements IntFunction<Integer> {
    @Override
    public Integer apply(int value) {
        int valueResult = new Double(value*0.5).intValue();
        System.out.println(getClass().getName()+" amount: "+valueResult);
        return valueResult;
    }
}
