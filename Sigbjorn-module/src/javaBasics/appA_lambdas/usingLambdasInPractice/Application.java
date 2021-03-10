package javaBasics.appA_lambdas.usingLambdasInPractice;

public class Application {
    public static void main(String[] args) {
        Helper.outputString("Application #1");

        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        Helper.outputString("Application #2");

    }
}
