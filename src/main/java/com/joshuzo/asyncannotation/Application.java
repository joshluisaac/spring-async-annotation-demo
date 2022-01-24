package com.joshuzo.asyncannotation;

import java.util.stream.IntStream;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

  public static void main(String[] args) {

    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    BatchService batchService = context.getBean(BatchService.class);
    IntStream.range(0, 18).forEach(entry -> batchService.longRunningMethod());
    IntStream.range(0, 10).forEach(entry -> batchService.quickMethod());
    try {
      batchService.throwsException();
    } catch (Exception e) {
      System.out.println("Will not be caught!");
    }
    System.out.println("Completed from " + Utils.threadName());
  }
}
