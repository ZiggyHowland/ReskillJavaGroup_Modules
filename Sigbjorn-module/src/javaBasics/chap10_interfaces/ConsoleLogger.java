package javaBasics.chap10_interfaces;


public class ConsoleLogger implements Logger {
    public void logStringMessage(String message) {
        System.out.println(message);
    }
}
