package com.study;


public class SimpleLambdasThisRef {
    public void say(){
        new Thread(()->{
            System.out.println(this.getWord());
        }).start();
    }
    public String getWord(){
        return "hello";
    }
    public static void main(String[] args) {
        new SimpleLambdasThisRef().say();
    }
}
