package javaBasics.appA_lambdas;

interface Command<T> {
    void execute(T target);
}

interface Calculation<T> {
    T perform(T op1, T op2);
}

class Person {
    public String name = "Sigbjørn";
}

public class LambdasFromSlides {
    public static void main(String[] args) {
//        Command<Person> displayPersonName = p -> System.out.println(p.name); // Lambda implementing the Command-interface
//        displayPersonName.execute(new Person()); // Call that invokes the lambda expression code

        doCommand(new Person(), p -> System.out.println(p.name));
        doCalculation(77, 23, (a, b) -> a + b);

    }

    private static <T> void doCommand(T target, Command<T> command) {
        command.execute(target);
    }

    private static <T> void doCalculation(T val1, T val2, Calculation<T> calculation) {
        T result = calculation.perform(val1, val2);
        System.out.println("Calculation result: " + result);
    }





}
