package javaBasics.appA_lambdas;

// Interface is public to package if no visibiltiy is added
// cannot write public - because it's not in a separate file
// Inteface with only one method is called a 'Functional interface'

interface UnaryOperation {
    double action(double n);
}
