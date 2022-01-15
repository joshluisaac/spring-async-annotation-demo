package com.joshuzo.asyncannotation;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

import static com.joshuzo.asyncannotation.Utils.logThread;
import static com.joshuzo.asyncannotation.Utils.threadName;
import static com.joshuzo.asyncannotation.Utils.waitFor;

@Service
public class BatchService {


    @Async("threadPoolTaskExecutor")
    public void longRunningMethod(){
        doWork(40000);
    }

    @Async("threadPoolTaskExecutor")
    public void quickMethod(){
        doWork(400);
    }

    private void doWork(int timeout){
        waitFor(timeout);
        System.out.println("Completed work from " + threadName());
    }

    @Async("threadPoolTaskExecutor")
    public void returnsSomething() {

    }

    @Async("threadPoolTaskExecutor")
    public void throwsException() {

    }

}
