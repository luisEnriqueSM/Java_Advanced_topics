package org.training.streams.intermediate.operations;

import java.util.stream.Stream;

public class Filters {

    public static void main(String[] args){
        new Filters().showCountryNames();
    }

    private void showCountryNames(){
        // Stream<T> filter(Predicate)
        // The filter() method returns a Stream with the elements that
        // Match the given predicate.
        Stream.of("galway", "mayo", "roscommon")
                .filter(countryName -> countryName.length() > 5)
                .forEach(System.out::println); // galway roscommon
    }
}
