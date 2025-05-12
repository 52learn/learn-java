package com.study.gc;

public class GCTest {
    public static void main(String[] args) {
        if (true) {
            byte[] placeHolder = new byte[64 * 1024 * 1024];
            placeHolder=null;
            byte[] placeHolder2 = new byte[64 * 1024 * 1024];
            //placeHolder2=null;
        }
        //byte[] sss  =  new byte[0];
        test();
        System.gc();
    }

    static void test(){
        byte[] placeHolder = new byte[64 * 1024 * 1024];
        //System.out.println(placeHolder.length / 1024);
    }
}
