package org.training.streams.terminal.operations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PartitioningBy {

    public static void main(String[] args){
        new PartitioningBy().partitioningByStartsWith();
        new PartitioningBy().greaterThanFour();
        new PartitioningBy().partitioningBy();
        new PartitioningBy().partitioningBySet();
    }

    private void partitioningByStartsWith(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.startsWith("T"))
                );
        System.out.println(map); // {false=[Mike, Alan, Peter], true=[Thomas, Teresa]}
    }

    private void greaterThanFour(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // pass in a Predicate
                        Collectors.partitioningBy(s -> s.length() > 4)
                );
        System.out.println(map); // {false=[Mike, Alan], true=[Thomas, Teresa, Peter]}
    }

    private void partitioningBy(){
        Stream<String> names = Stream.of("Thomas", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, List<String>> map =
                names.collect(
                        // forcing an empty list
                        Collectors.partitioningBy(s -> s.length() > 10)
                );
        System.out.println(map); // {false=[Thomas, Teresa, Mike, Alan, Peter], true=[]}
    }

    private void partitioningBySet(){
        Stream<String> names = Stream.of("Alan", "Teresa", "Mike", "Alan", "Peter");
        Map<Boolean, Set<String>> map =
                names.collect(
                        Collectors.partitioningBy(
                                s -> s.length() > 4,
                                Collectors.toSet()
                        )
                );
        System.out.println(map); // {false=[Mike, Alan], true=[Teresa, Peter]}
    }
}
