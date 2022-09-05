package com.study.design.pattern.decorator;

/**
 * 原始的装饰器模式
 */
public class PriceMain {
    public static void main(String[] args) {
        Book book = new Book(100);
        Item finalPrice = new DeliveryService(new GiftPacking(book));
        System.out.println("finalPrice:"+finalPrice.getPrice());

    }
}
