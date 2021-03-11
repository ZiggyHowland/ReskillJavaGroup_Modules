package javaBasics.appA_lambdas.usingLambdasInPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        streams();


//        demo1();
//        System.out.println("---------------------------");
//        demo2();

    }



    private static void streams() {
        List<Double> hoursWorked = MyArrays.asList(7.5, 8.25, 9.0, 7.0, 6.5);
        Stream<Double> stream = hoursWorked.stream();
        double sumExtraHours = stream.filter( h -> h > 7.5)
                                    .mapToDouble(h -> h - 7.5)
                                    .sum();

        System.out.println("Extra hours: " + sumExtraHours);


    }


    private static void demo1() {
        ConsoleHelper.displayMessage("Application #1");

        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        ConsoleHelper.displayMessage("Application #2");
    }


    private static void demo2() {
        ConsoleHelper.displayMessage("Application #3");

        Thread t2 = new Thread( () -> ConsoleHelper.displayMessage("Hei") );
        t2.start();

        ConsoleHelper.displayMessage("Application #4");
    }
}




/**
 * Just testing how we could implement Arrays.asList ourselves.
 */
class MyArrays {
    public static <T> List<T> asList(T... args) {
        List<T> collection = new ArrayList<>();
        for (T a : args ) {
            collection.add(a);
        }
        return collection;
    }
}
