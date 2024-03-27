package org.training.streams.terminal.operations;

import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Reduce {

    public static void main(String[] args){
        new Reduce().combineStreamString();
        new Reduce().combineStreamInteger();
        new Reduce().optionalReduce();
        new Reduce().sumCharacters();
    }

    private void combineStreamString(){
        String name = Stream.of("s", "e", "a", "n")
                .reduce("", (s,c) -> s + c);
        System.out.println(name); // sean
    }

    private void combineStreamInteger(){
        Integer product = Stream.of(2,3,4)
                .reduce(1, (a,b) -> a * b);
        System.out.println(product); // 24
    }

    private void optionalReduce(){
        BinaryOperator<Integer> op = (a,b) -> a+b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(6);
        Stream<Integer> multipleElements = Stream.of(3,4,5);
        empty.reduce(op).ifPresent(System.out::println);   // empty
        oneElement.reduce(op).ifPresent(System.out::println); // 6
        multipleElements.reduce(op).ifPresent(System.out::println); // 12

        Integer val = Stream.of(1,1,1)
                .reduce(1, (a,b) -> a); // val is 1 this way too
        System.out.println(val); // 1
    }

    private void sumCharacters(){
        Stream<String> stream = Stream.of("car", "bus", "train", "aeroplane");
        int length = stream.reduce(0, // identity
                (n, str) -> n + str.length(), // n is Integer
                (n1, n2) -> n1 + n2);   // both are Integers
        System.out.println(length); // 20
    }
}
