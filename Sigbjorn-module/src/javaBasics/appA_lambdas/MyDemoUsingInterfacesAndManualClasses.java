package javaBasics.appA_lambdas;

import java.util.ArrayList;



class SquareOperation implements UnaryOperation {
    @Override
    public double action(double n) {
        return n*n;
    }
}

class CubeOperation implements UnaryOperation {
    @Override
    public double action(double n) {
        return n*n*n;
    }
}

class Power4Operation implements UnaryOperation {
    @Override
    public double action(double n) {
        return n*n*n*n;
    }
}


public class MyDemoUsingInterfacesAndManualClasses {
    public static void main(String[] args) {
        ArrayList<Double> temperatures = new ArrayList<>();
        temperatures.add(5.0);
        temperatures.add(-3.0);
        temperatures.add(32.0);

        displayResultOfOperation(temperatures, new SquareOperation());
        displayResultOfOperation(temperatures, new CubeOperation());
        displayResultOfOperation(temperatures, new Power4Operation());
    }

    private static void displayResultOfOperation(ArrayList<Double> numbers, UnaryOperation operation) {
        for (double n: numbers) {
            double result = operation.action(n);
            System.out.println(result);

        }

    }




}
