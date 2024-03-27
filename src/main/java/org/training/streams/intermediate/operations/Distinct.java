package org.training.streams.intermediate.operations;

import java.util.stream.Stream;

public class Distinct {

    public static void main(String[] args){
        new Distinct().duplicateWords();
    }

    private void duplicateWords(){
        // Stream<T> distinct()
        // distinct() is a stateful intermediate operation
        // Output: 1. eagle 2. eagle 1. eagle 1. EAGLE 2. EAGLE
        Stream.of("eagle", "eagle", "EAGLE")
                .peek(s -> System.out.print(" 1. " + s))
                .distinct()
                .forEach(s -> System.out.print(" 2. " + s));
    }
}
