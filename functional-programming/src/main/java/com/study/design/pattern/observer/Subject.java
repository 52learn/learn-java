package com.study.design.pattern.observer;

public interface Subject {
    void registerObserver(Observer observer);
    void notifyObserver();
}
