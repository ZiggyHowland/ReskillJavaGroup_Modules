package javaBasics.appA_lambdas;

@FunctionalInterface
public interface MyFunction<T, R> {
    R apply(T param);
    // T is a placeholder for whatever type you pass in
    //
}
