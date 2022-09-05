package com.study.design.pattern.observer;

import java.util.function.DoubleUnaryOperator;

public class ObserverMain {

    public static void main(String[] args) {

        ExchangeRateServer exchangeRateServer = new ExchangeRateServer(100);
        exchangeRateServer.registerObserver(rate -> {
            System.out.println("NiBo Bank receive rate :"+rate);
        });
        exchangeRateServer.registerObserver(rate -> {
            System.out.println("ICBC Bank receive rate :"+rate);
        });
        exchangeRateServer.registerObserver(rate -> {
            System.out.println("HangZhou Bank receive rate :"+rate);
        });
        exchangeRateServer.notifyObserver();
    }
}
