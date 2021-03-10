package javaBasics.appA_lambdas;


import java.util.ArrayList;

public class MyDemoClunky {
    public static void main(String[] args) {
        ArrayList<Double> temperatures = new ArrayList<>();
        temperatures.add(5.0);
        temperatures.add(-3.0);
        temperatures.add(32.0);

        displaySquares(temperatures);
        displayCubes(temperatures);
        displayToPower4(temperatures);
    }

    // Integer is a wrapper class for int
    private static void displaySquares(ArrayList<Double> numbers) {
        for (double n: numbers) {
            double result = n * n;
            System.out.println(result);

        }

    }

    private static void displayCubes(ArrayList<Double> numbers) {
        for (double n: numbers) {
//            double result = n * n * n;
            double result = Math.pow(n, 3);
            System.out.println(result);

        }

    }

    private static void displayToPower4(ArrayList<Double> numbers) {
        for (double n: numbers) {
//            double result = n * n * n;
            double result = Math.pow(n, 4);
            System.out.println(result);

        }

    }
}
