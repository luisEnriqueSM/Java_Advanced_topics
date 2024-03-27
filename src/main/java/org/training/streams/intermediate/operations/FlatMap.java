package org.training.streams.intermediate.operations;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap {

    public static void main(String[] args){
        // combine List of strings
        List<String> list1 = Arrays.asList("sean", "desmond");
        List<String> list2 = Arrays.asList("marry", "ann");
        Stream<List<String>> streamOfLists = Stream.of(list1, list2);

        // flatMap(Function(T, R)) IN:T OUT:R
        //  flatMap(List<String>, Stream<String)
        streamOfLists.flatMap(list -> list.stream())
                .forEach(System.out::print);  // seandesmondmarryann
    }
}
