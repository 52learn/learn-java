package com.study.design.pattern.decorator;

public class Book implements Item{
    private int price;

    public Book(int price){
        this.price = price;
    }
    @Override
    public int getPrice() {
        System.out.println("book price:"+this.price);
        return this.price;
    }
}
