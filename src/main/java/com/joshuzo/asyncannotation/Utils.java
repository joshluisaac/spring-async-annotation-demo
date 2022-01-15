package com.joshuzo.asyncannotation;

public class Utils {

    public static void logThread(){
        System.out.println(threadName());
    }

    public static String threadName(){
        return Thread.currentThread().getName() + "-thread";
    }

    public static  void waitFor(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }


}
