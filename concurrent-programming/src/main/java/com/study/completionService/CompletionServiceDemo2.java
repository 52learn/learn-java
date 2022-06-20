package com.study.completionService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 并行执行：task1,task2,task3  main线程阻塞获取一个优先计算完成的任务执行结果，取消其他的执行任务。
 *
 */
public class CompletionServiceDemo2 {

    public static void execute(){
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,4,5, TimeUnit.SECONDS,queue);
        List<Future> futures = new ArrayList<>();
        CompletionService completionService = new ExecutorCompletionService<>(executor);
        Future<String> future1 = completionService.submit(()->{
            String taskName = "task1";
            int millis = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" doing....consume: "+millis);
            TimeUnit.MILLISECONDS.sleep(millis);
            return taskName;
        });
        futures.add(future1);
        Future<String> future2 =  completionService.submit(()->{
            String taskName = "task2";
            int millis = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" doing....consume: "+millis);
            TimeUnit.MILLISECONDS.sleep(millis);
            return taskName;
        });
        futures.add(future2);
        Future<String> future3 = completionService.submit(()->{
            String taskName = "task3";
            int millis = new Random().nextInt(9000);
            System.out.println(time()+"--taskName:"+taskName+" doing....consume: "+millis);
            TimeUnit.MILLISECONDS.sleep(millis);
            return taskName;
        });
        futures.add(future3);


        try {
            for(int i=0;i<3;i++) {
                Future<String> future = completionService.take();
                System.out.println(time() + "--result: " + future.get() + ", break....");
                break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            //取消所有任务
            for(Future f : futures) {
                f.cancel(true);
            }
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

        System.out.println(time()+"--finish....");
    }



    public static void main(String[] args) {
        CompletionServiceDemo2.execute();
    }

    private static String time(){
       return LocalTime.now().toString();
    }
}
