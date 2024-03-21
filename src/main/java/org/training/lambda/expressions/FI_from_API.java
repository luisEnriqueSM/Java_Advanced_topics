package org.training.lambda.expressions;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FI_from_API {

    public static void main(String[] args){
        FI_from_API fiAPI = new FI_from_API();
        //fiAPI.predicate();
        //fiAPI.supplier();
        //fiAPI.consumer();
        //fiAPI.function();
        fiAPI.unaryBinaryOperator();
    }

    public void predicate(){
        // Predicate<T> is a functional interface i.e. one abstract method:
        // boolean test(T t);
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Mexico City"));

        // BiPredicate<T,U> is a functional interface i.e. one abstract method:
        // boolean test(T t, U u);
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Mexico City", 8));
    }

    public void supplier(){
        // Supplier<T> is a functional interface i.e. one abstract method:
        // T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());
    }

    public void consumer(){
        // Consumer<T> is a functional interface i.e. one abstract method
        // void accept(T t);
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("Simple message with no return value");

        List<String> names = new ArrayList<>();
        names.add("Luis");
        names.add("Nico");
        names.add("Silvia");
        names.forEach(printC);

        // BiConsumer<T,U> is a functional interface i.e. one abstract method:
        // void accept(T t, U u);
        var mapCapitalCities = new HashMap<String, String>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Mexico", "Mexico City");
        biCon.accept("Spain", "Madrid");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) ->
                System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint);
    }

    public void function(){
        // Function<T, R> is a functional interface i.e. one abstract method:
        // R apply(T, t);
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Mexico"));

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        // R apply(T t, U u);
        BiFunction<String, String, Integer> biFn = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("Luis", "Enrique"));

        // input, input, output
        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("Luis ", "Enrique"));
    }

    public void unaryBinaryOperator(){
        // The input and output type must match
        // UnaryOperator<T> extends Function<T,T> is a functional interface i.e. one abstract method:
        // T apply(T t);
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Luis"));

        // BinaryOperator<T> extends BiFunction<T,T,T> is a functional interface i.e. one abstract method:
        // T apply(T t1, T t2);
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("Luis " , "Enrique"));
    }
}
