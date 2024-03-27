package org.training.streams.terminal.operations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingBy {

    public static void main(String[] args){
        new GroupingBy().groupByLength();
        new GroupingBy().groupByWithSet();
        new GroupingBy().groupByWithTreeMap();
    }

    private void groupByLength(){
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, List<String>> map =
                names.collect(
                        // passing in a Function that determines the
                        // key in the Map
                        Collectors.groupingBy(String::length) // s -> s.length()
                );
        System.out.println(map); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
    }

    private void groupByWithSet(){
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        Map<Integer, Set<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,     // key function
                                Collectors.toSet()  // what to do with the values
                        )
                );
        System.out.println(map); // {3=[Joe, Tom], 4=[Alan], 5=[Peter]}
    }

    private void groupByWithTreeMap(){
        Stream<String> names = Stream.of("Joe", "Tom", "Tom", "Alan", "Peter");
        TreeMap<Integer, List<String>> map =
                names.collect(
                        Collectors.groupingBy(
                                String::length,
                                TreeMap::new,         // map type Supplier
                                Collectors.toList()   // downstream collector
                        )
                );
        System.out.println(map); // {3=[Joe, Tom, Tom], 4=[Alan], 5=[Peter]}
        System.out.println(map.getClass());
    }
}
