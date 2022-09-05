package com.study;


public class SimpleAnonymousInnerClass {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(" anonymout inner class ...");
            }
        }).start();
    }
}
