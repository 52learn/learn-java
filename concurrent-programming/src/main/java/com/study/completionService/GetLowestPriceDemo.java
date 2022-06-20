package com.study.completionService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 并行执行：task1,task2,task3
 * main线程阻塞获取三个task中的最低价格
 *
 */
public class GetLowestPriceDemo {

    public static void execute(){
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5, TimeUnit.SECONDS,queue);
        List<Future> futures = new ArrayList<>();
        CompletionService completionService = new ExecutorCompletionService<>(executor);
        Future<Integer> future1 = completionService.submit(()->{
            String taskName = "task1";
            int price = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" price: "+price);
            return price;
        });
        futures.add(future1);
        Future<Integer> future2 =  completionService.submit(()->{
            String taskName = "task2";
            int price = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" price: "+price);
            return price;
        });
        futures.add(future2);
        Future<Integer> future3 = completionService.submit(()->{
            String taskName = "task3";
            int price = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" price: "+price);
            return price;
        });
        futures.add(future3);

        AtomicReference<Integer> lowestPrice = new AtomicReference<>(Integer.MAX_VALUE);
        try {
            for(int i=0;i<3;i++) {
                Future<Integer> future = completionService.take();
                lowestPrice.set(Integer.min(lowestPrice.get(),future.get()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
/*
        for(Future<String> future:futures){
            try {
                String result = future.get();
                System.out.println(time()+"--result: "+result + ", break....");
                break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }*/
        System.out.println("lowest price: "+lowestPrice.get());
        System.out.println(time()+"--finish....");
    }



    public static void main(String[] args) {
        GetLowestPriceDemo.execute();
    }

    private static String time(){
       return LocalTime.now().toString();
    }
}
