package org.training.streams;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MappingPrimitiveStreams {

    public static void main(String[] args){

        // IntStream to Stream<T>
        Stream<String> streamAges = IntStream.of(1,2,3)
                // mapToObject(IntFunction<R>)
                //      intFunction is a functional interface
                //          R apply(int value)
                .mapToObj(n -> "Number: " + n);
        // forEach is a terminal operation which closes the stream
        // forEach(Consumer) - Consumer is a functional interface:
        //      void accept(T t)
        streamAges.forEach(System.out::println); // Number: 1 Number: 2 Number: 3

        // IntStream to DoubleStream
        DoubleStream dblStream = IntStream.of(1,2,3) // must open stream again as it is closed!
                // mapToDouble(IntToDoubleFunction)
                //      IntToDoubleFunction is a functional interface:
                //          double applyAsDouble(int value)
                .mapToDouble(n -> (double) n); // cast not necessary --- n -> n
        dblStream.forEach(System.out::println); // 1.0 2.0 3.0

        // IntStream to IntStream
        IntStream.of(1,2,3)
                //  map(IntUnaryOperator)
                //      IntUnaryOperator is a functional interface:
                .map(n -> n * 2)
                .forEach(System.out::println); // 2 4 6

        // IntStream to LongStream
        IntStream.of(1,2,3) // must open stream again as 'intStream' is closed!
                // mapToLong(IntToLongFunction)
                //      IntToLongFunction is a functional interface:
                //          long applyAsLong(int value)
                .mapToLong(n -> (long) n) // cat Not necessary ---- n -> n
                .forEach(System.out::println); // 1 2 3


    }
}
