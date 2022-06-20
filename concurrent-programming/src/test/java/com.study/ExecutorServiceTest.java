package com.study;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void testSubmit() throws Exception {
        // 创建异步执行任务:
        ExecutorService executorService= Executors.newSingleThreadExecutor();

        Future<Double> cf = executorService.submit(()->{
            logger.info(Thread.currentThread()+" start");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            logger.info(Thread.currentThread()+" exit");
            return 1.2;
        });
        logger.info("main thread start...");
        //等待子任务执行完成,如果已完成则直接返回结果
        //如果执行任务异常，则get方法会把之前捕获的异常重新抛出
        logger.info("run result->"+cf.get());
        logger.info("main thread exit...");
    }
}
