package com.study.completionService;

import java.util.concurrent.*;

/**
 * 并行执行：task1,task2,task3  main线程循环阻塞获取task1,task2,task3执行结果。
 *
 */
public class CompletionServiceDemo {

    public static void execute(){
        BlockingQueue queue = new LinkedBlockingQueue();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.SECONDS,queue);

        CompletionService completionService = new ExecutorCompletionService<>(executor);
        completionService.submit(()->{
            String taskName = "task1";
            System.out.println("taskName:"+taskName+" doing....");
            TimeUnit.SECONDS.sleep(1);
            return taskName;
        });
        completionService.submit(()->{
            String taskName = "task2";
            System.out.println("taskName:"+taskName+" doing....");
            TimeUnit.SECONDS.sleep(2);
            return taskName;
        });
        completionService.submit(()->{
            String taskName = "task3";
            System.out.println("taskName:"+taskName+" doing....");
            TimeUnit.SECONDS.sleep(3);
            return taskName;
        });
        for(int i=0;i<3;i++){
            try {
                System.out.println(" before completionService.take 。。");
                Future<String> future = completionService.take();
                System.out.println("future take .... i:"+i);
                String result = future.get();
                System.out.println("result: "+result +", i:"+i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        System.out.println("finish....");
    }



    public static void main(String[] args) {
        CompletionServiceDemo.execute();
    }

}
