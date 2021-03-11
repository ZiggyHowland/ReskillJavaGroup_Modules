package javaBasics.appA_lambdas.usingLambdasInPractice;


public class MyRunnable implements Runnable {

    @Override
    public void run() {
        ConsoleHelper.displayMessage("Greetings from MyRunnable");
        ConsoleHelper.pauseWithIndicators(500, 10);
        ConsoleHelper.displayMessage("Good by from MyRunnable");
    }







}
