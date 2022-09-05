package com.study;


public class SimpleLambdas {
    public static void main(String[] args) {
        new Thread(
            ()->{System.out.println(" anonymout inner class ...");}
        ).start();
    }
}
