package javaBasics.appA_lambdas;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;


public class MyDemoUsingInterfacesAndLambdas {
    public static void main(String[] args) {
        ArrayList<Double> temperatures = new ArrayList<>();
        temperatures.add(5.0);
        temperatures.add(-3.0);
        temperatures.add(32.0);

        /*
         A lambda is an object that implements the functional interface
         */
//        displayResultOfOperation(temperatures, n -> n + n); //This is our implementation of the method action()
//        displayResultOfOperation(temperatures, n -> Math.pow(n, 5));

//        Predicate<Double> pred1 = p -> p % 2 == 0;
//        displayItemsWhere(temperatures, pred1);

//        transformAndDisplay(temperatures, n -> String.format("The number is %.2f", n));


        // FUNCTION interface
        transformAndDisplay(temperatures, n -> {
            String s = String.format("The number is %.2f", n);
            return s;
        });

        System.out.println("----- Wholy crap -----");

        // BINARY interface
        transformAndDisplayV2(temperatures, (n, s) -> {
            String ret = String.format(s, n);
            return ret;
        });


        // Celsius to Fahrenheit
        convertWithTwoValues(temperatures, c -> c * 1.8 + 32);
        convertWithTwoValues(temperatures, f -> (f - 32) / 1.8);
    }





    private static void displayResultOfOperation(ArrayList<Double> numbers, UnaryOperation operation) {
        for (double n: numbers) {
            double result = operation.action(n);
            System.out.println(result);
        }
    }

    private static void displayItemsWhere(ArrayList<Double> numbers, Predicate pred) {
        for (double n: numbers) {
            if (pred.test(n)) {
                System.out.println(n);
            }
        }
    }

    // You always call function parameters 'f'
    private static void transformAndDisplay(ArrayList<Double> numbers, Function<Double, String> f) {
        for (double n: numbers) {
            String s = f.apply(n);
            System.out.println(s);
        }
    }

    private static void transformAndDisplayV2(ArrayList<Double> numbers, BiFunction<Double, String, String> f) {
        for (double n: numbers) {
            String s = f.apply(n, "Le numéro est %.2f");
            System.out.println(s);
        }
    }

    private static void convertWithTwoValues(ArrayList<Double> numbers, UnaryOperator<Double> op) {
        for (double n: numbers) {
            double f = op.apply(n);
            System.out.println("Org temp is " + n + " / Converted temp is " + f);
        }
    }




    // Investigate BinaryOperator
    // Write a function to: display temperatures in Fahrenheit
    // CLUE: Pass in a suitable lambda (10 minutes)


    // multiply by 1.8 (or 9/5) and add 32.

}
