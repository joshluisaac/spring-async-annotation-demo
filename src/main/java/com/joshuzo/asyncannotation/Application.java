package com.joshuzo.asyncannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.stream.IntStream;


public class Application {

    public static void main(String[] args) {

        ApplicationContext  context = new AnnotationConfigApplicationContext(AppConfig.class);
        BatchService batchService = context.getBean(BatchService.class);
        IntStream.range(0,200).forEach(x -> batchService.longRunningMethod());
        batchService.quickMethod();
        batchService.quickMethod();
        batchService.quickMethod();
        batchService.quickMethod();
        batchService.quickMethod();
        System.out.println("Completed from " + Utils.threadName());
//        Utils.waitFor(6000);


    }



}