package org.training.streams.parallel;

import java.util.Arrays;
import java.util.stream.Stream;

public class ParallelStreams {

    public static void main(String[] args){
        // Sequential stream
        int sum = Stream.of(10,20,30,40,50,60)
                // IntStream has the sum() method so we use
                // the mapToInt() method to map from Stream<Integer>
                // to an IntStream (i.e. a stream of int primitives).
                // IntStream mapToInt(ToIntFunction)
                //      ToIntFunctions is a functional interface:
                //          int applyAsInt(T value)
                .mapToInt(n -> n.intValue())
                // .mapToInt(Integer::intValue)
                // .mapToInt(n -> n)
                .sum();
        System.out.println("Sum == " + sum);

        // Parallel Stream
        int sum2 = Stream.of(10, 20, 30, 40, 50, 60)
                .parallel()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("Sum == " + sum2);

        sequentialStream();
        parallelStream();
    }

    private static void sequentialStream(){
        Arrays.asList("a", "b", "c") // create List
                .stream()   // stream the List
                .forEach(System.out::print); // abc
    }

    private static void parallelStream(){
        Arrays.asList("a", "b", "c") // create List
                .stream()    // stream the List
                .parallel()
                .forEach(System.out::print); // bca
    }
}
