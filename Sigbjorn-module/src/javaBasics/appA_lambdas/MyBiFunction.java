package javaBasics.appA_lambdas;

@FunctionalInterface
public interface MyBiFunction<T, U, R> {
    R apply(T p1, U p2);

}
