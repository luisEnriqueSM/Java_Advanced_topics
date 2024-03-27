package org.training.streams.terminal.operations;

import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collector {

    public static void main(String[] args){
        new Collector().collectorJoining();
        new Collector().collectorAvg();
        new Collector().collectorToMap();
        new Collector().collectorToMapDuplicateKey();
        new Collector().collectorToTreeMap();
    }

    private void collectorJoining(){
        String s = Stream.of("cake", "biscuits", "apple tart")
                .collect(Collectors.joining(", "));
        System.out.println(s);  // cake, biscuits, apple tart
    }

    private void collectorAvg(){
        Double avg = Stream.of("cake", "biscuits", " apple tart")
                // averagingInt(ToIntFunction) functional method is:
                //      int applyAsInt(T value);
                .collect(Collectors.averagingInt(s -> s.length()));
        System.out.println(avg); // 7.666666666666667
    }

    private void collectorToMap(){
        // We want a map: dessert name -> number of characters in dessert name
        // Output:
        //
        Map<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart")
                        .collect(Collectors.toMap(s -> s,        // Function for the key
                                                    s -> s.length())); // Function for the value
        System.out.println(map); // {biscuits=8, cake=4, apple tart=10}
    }

    private void collectorToMapDuplicateKey(){
        Map<Integer, String> map =
                Stream.of("cake", "biscuits", "tart")
                        .collect(
                                Collectors.toMap(s -> s.length(), // key is length
                                                 s -> s,          // value is the string
                                        (s1, s2) ->  s1 + "," + s2) // Merge function - what to
                                        // do if we have duplicate keys - append the values
                        );
        System.out.println(map);  // {4=cake,tart, 8=biscuits}
    }

    private void collectorToTreeMap(){
        TreeMap<String, Integer> map =
                Stream.of("cake", "biscuits", "apple tart", "cake")
                        .collect(
                                Collectors.toMap(s -> s,   // key is the string
                                                 s -> s.length(), // value is the length of the string
                                        (len1, len2) -> len1 + len2, // what to do if we have duplicate keys
                                        // - add the "values"
                                        () -> new TreeMap<>())); // TreeMap::new works
        System.out.println(map);  // {apple tart=10, biscuits=8, cake=8}
        System.out.println(map.getClass());
    }
}
