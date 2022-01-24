package com.joshuzo.asyncannotation;

import static com.joshuzo.asyncannotation.Utils.threadName;
import static com.joshuzo.asyncannotation.Utils.waitFor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async("threadPoolTaskExecutor")
public class BatchService {

  public void longRunningMethod() {
    doWork(10000);
  }

  public void quickMethod() {
    doWork(400);
  }

  public void returnsSomething() {}

  public void throwsException() {
    throw new RuntimeException("Error occurred.");
  }

  private void doWork(int timeout) {
    waitFor(timeout);
    System.out.println("Completed work from " + threadName());
  }
}
