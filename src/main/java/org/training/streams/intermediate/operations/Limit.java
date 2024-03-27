package org.training.streams.intermediate.operations;

import java.util.stream.Stream;

public class Limit {

    public static void main(String[] args){
        // Stream<T> limit(long maxSize)
        // limit is a short-circuiting stateful
        // intermediate operation. Lazy evaluation - 66, 77, 88 and 99
        // are not streamed as they are not needed(lit of 2 i.e. 44 and 55).
        // Output:
        // A - 11 A - 22 A - 33 A - 44 B - 44 C - 44 A - 55 B - 55 C - 55
        Stream.of(11,22,33,44,55,66,77,88,99)
                .peek(n -> System.out.print(" A - " + n))
                .filter(n -> n > 40)
                .peek(n -> System.out.print(" B - " + n))
                .limit(2)
                .forEach(n -> System.out.print(" C - " + n));
    }
}
