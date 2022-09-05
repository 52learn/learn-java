package com.study.design.pattern.decorator;

public class DeliveryService implements Item{
    private Item item;
    public DeliveryService(Item item){
        this.item = item;
    }
    @Override
    public int getPrice() {
        int basePrice = item.getPrice();
        int price = basePrice+10;
        System.out.println("DeliveryService getPrice:"+price+", base price:"+basePrice);
        return price;
    }
}
