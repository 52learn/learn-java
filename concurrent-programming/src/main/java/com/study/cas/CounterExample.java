package com.study.cas;

import sun.misc.Unsafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterExample {

    static AtomicInteger counter = new AtomicInteger(0);
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        new Thread(new CounterRunnable(countDownLatch)).start();
        new Thread(new CounterRunnable(countDownLatch)).start();
        try {
            countDownLatch.await();
            System.out.println("counter:"+counter);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class CounterRunnable implements Runnable{
        CountDownLatch countDownLatch;
        public CounterRunnable(CountDownLatch countDownLatch){
            this.countDownLatch = countDownLatch;
        }
        @Override
        public void run() {
            for(int j=1;j<=1000;j++){
                /*synchronized (CounterExample.class){
                    counter++;
                }*/

                /**/
                for(;;){
                    // 读取共享变量：counter
                    int _counter = counter.get();
                    // 将共享变量加1
                    int newCount = _counter+1;
                    // 通过cas操作共享变量counter
                    boolean result = counter.compareAndSet(_counter,newCount);
                    // 若cas操作成功，则表明本轮for循环中的共享变量操作是线程安全的，则退出for循环；
                    // 否则继续新一轮for循环，直到cas操作成功；
                    if(result){
                        break;
                    }
                }

            }
            countDownLatch.countDown();
            System.out.println("CounterRunnable finished!");
        }
    }
}
