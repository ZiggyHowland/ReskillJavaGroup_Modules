package javaBasics.appA_lambdas.usingLambdasInPractice;

import java.time.LocalTime;

public class Helper {
    public static void outputString(String message) {
        System.out.printf("[%S] %s (Thread ID: %d)%n",
                LocalTime.now() ,
                message ,
                Thread.currentThread().getId()
        );
    }
}
