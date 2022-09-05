package com.study.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class ExchangeRateServer implements Subject{
    List<Observer> observers = new ArrayList<>();
    private double rate;
    public ExchangeRateServer(double rate){
        this.rate = rate;
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer -> {
            observer.onNotify(rate);
        });
    }

}
