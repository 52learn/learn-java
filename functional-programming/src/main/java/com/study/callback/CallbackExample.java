package com.study.callback;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class CallbackExample {

    public static void main(String[] args) {
        hello("tom",()->"anonymous");
        hello(null,()->"anonymous");

        Consumer<String> helloConsumer = (userName)->{
            String finalUserName = Optional.ofNullable(userName)
                .orElse("anonymous");
            System.out.println("hello :"+finalUserName);
        };
        hello("ketty",helloConsumer);
        hello(null,helloConsumer);
    }

    static void hello(String userName, Supplier<String> callback){
       String finalUserName = Optional.ofNullable(userName)
            .orElseGet(callback);
        System.out.println("hello : "+finalUserName);
    }


    static void hello(String userName, Consumer<String> callback){
        callback.accept(userName);
    }

}
