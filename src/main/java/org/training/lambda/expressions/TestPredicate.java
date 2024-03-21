package org.training.lambda.expressions;

import java.util.function.Predicate;

interface Evaluate<T>{
    boolean isNegative(T t); // similar to Predicate
}
public class TestPredicate {

    public static void main(String[] args){
        // Evaluate<T> is a functional interface i.e. one abstract method:
        // boolean isNegative(T t); // similar to java.util.function.Predicate
        Evaluate<Integer> lambda = i -> i < 0;
        // Evaluate<Integer> lambda = { return i < 0;};
        // The lambda expression is being executed when call the isNegative method
        System.out.println("Evaluate: " + lambda.isNegative(-1));
        System.out.println("Evaluate: " + lambda.isNegative(+1));

        // Predicate<T> is a functional interface i.e. one abstract method:
        // boolean test(T t)
        Predicate<Integer> predicate = i -> i < 0;
        System.out.println("Predicate: " + predicate.test(-1));
        System.out.println("Predicate: " + predicate.test(+1));

        int x = 4;
        System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0));
        x = 7;
        System.out.println("Is " + x + " even? " + check(7, n -> n % 2 == 0));

        String name = "Mr. Luis";
        System.out.println("Does " + name + " start with Mr. ? " +
                check(name, s -> s.startsWith("Mr."))); // true

        name = "Ms Tchala";
        System.out.println("Does " + name + " start with Mr. ? " +
                check(name, s -> s.startsWith("Mr.")));
    }

    public static <T> boolean check(T t, Predicate<T> lambda){
        return lambda.test(t);
    }
}
