package javaBasics.appA_lambdas.usingLambdasInPractice;

import java.time.LocalTime;

public class ConsoleHelper {
    public static void displayMessage(String message) {
        System.out.printf("[%S] %s (Thread ID: %d)%n",
                LocalTime.now() ,
                message ,
                Thread.currentThread().getId()
        );
    }

    public static void pauseWithIndicators(int ms, int limit) {
        try {
            int count = 0;
            do {
                // Consultancy loop
                System.out.print('.');
                Thread.sleep(ms);
                count++;
            } while (count < limit);
            System.out.println(".");
        }
        catch (InterruptedException e) {

        }

    }

}
