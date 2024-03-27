package org.training.streams.intermediate.operations;

import java.util.stream.Stream;

public class Map {

    public static void main(String[] args){
        new Map().lengthOfWords();
    }

    private void lengthOfWords(){
        // <R> Stream<R> map(Function<T,R> mapper)
        //      Function's functional method: R apply(T t);
        Stream.of("book", "pen", "ruler")
                .map(s -> s.length())// String::length
                .forEach(System.out::print); // 435
    }
}
