package org.training.streams.intermediate.operations;

import java.util.IntSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {

    public static void main(String[] args){
        // 1. Using Stream<T> and reduce(identity, accumulator)
        Stream<Integer> numbers = Stream.of(1,2,3);
        // Integer reduce(Integer identity, BinaryOperator accumulator)
        //      BinaryOperator extends BiFunction<T,T,T>
        //          T apply(T,T)
        // Starting the accumulator with 0
        //     n1 + n2
        //     0  + 1  == 1 (n1 now becomes 1)
        //     1 +  2  == 3 (n1 now becomes 3)
        //     3  + 3  == 6
        System.out.println(numbers.reduce(0, (n1, n2) -> n1 + n2)); // 6

        // 2. Using IntStream and sum()
        // IntStream mapToInt (ToIntFunction)
        //   ToIntFunction is a functional interface:
        //      int applyAsInt(T value);
        IntStream intS = Stream.of(1,2,3)
                .mapToInt(n -> n); // unboxed
        int total = intS.sum();
        System.out.println(total); // 6

        // 3.
        OptionalInt max = IntStream.of(10,20,30)
                .max(); // terminal operation
        max.ifPresent(System.out::println); // 30

        OptionalDouble min = DoubleStream.of(10.0, 20.0, 30.0)
                .min(); // terminal operation
        // NoSuchElementException is thrown if no value present
        System.out.println(min.orElseThrow()); // 10.0

        OptionalDouble average = LongStream.of(10L, 20L, 30L)
                .average(); // terminal operation
        System.out.println(average.orElseGet(() -> Math.random())); // 20.0

        // 4.
        stats(IntStream.of(5,10, 15, 20));
        stats(IntStream.empty());
    }

    public static void stats(IntStream numbers){
        IntSummaryStatistics intStats =
                numbers.summaryStatistics(); // terminal op
        int min = intStats.getMin();
        System.out.println(min); // 5 (2147483647 if nothing in stream)
        int max = intStats.getMax();
        System.out.println(max); // 20 (-2147483648 if nothing in stream)
        double avg = intStats.getAverage();
        System.out.println(avg); // 12.5 (0.0 if nothing to stream)
        long count = intStats.getCount();
        System.out.println(count); // 4 (0 if nothing in stream)
        long sum = intStats.getSum();
        System.out.println(sum); // 50 (0 if nothing in stream)
    }
}
