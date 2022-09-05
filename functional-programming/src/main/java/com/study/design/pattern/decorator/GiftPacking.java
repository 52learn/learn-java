package com.study.design.pattern.decorator;

public class GiftPacking implements Item{
    private Item item;

    public GiftPacking(Item item){
        this.item = item;
    }
    @Override
    public int getPrice() {
        int basePrice = item.getPrice();
        int price = basePrice*2;
        System.out.println("GiftPacking getPrice:"+price+", base price:"+basePrice);
        return price;
    }
}
