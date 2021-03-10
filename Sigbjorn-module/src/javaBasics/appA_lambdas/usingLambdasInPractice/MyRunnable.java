package javaBasics.appA_lambdas.usingLambdasInPractice;


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        Helper.outputString("Greetings from MyRunnable");

        // Consultancy loop
        try {
            int count = 0;
            do {
                Thread.sleep(1_000);
                System.out.print('.');
                count++;
            } while (count <= 10);
            System.out.println("");
        }
        catch (InterruptedException e) {

        }

        Helper.outputString("Good by from MyRunnable");
    }







}
