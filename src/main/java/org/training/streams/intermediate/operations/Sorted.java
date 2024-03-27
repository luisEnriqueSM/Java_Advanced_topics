package org.training.streams.intermediate.operations;

import java.util.stream.Stream;

public class Sorted {

    public static void main(String[] args){
        // Stream<T> sorted()
        // Stream<T> sorted(Comparator<T> comparator)
        // Output:
        // 0.Tim 1.Tim 0.Jim 1.Jim 0.Peter 0.Ann 1.Ann 0.Mary 2.Ann 3.Ann 2.Jim 3.Jim
        Stream.of("Tim", "Jim", "Peter", "Ann", "Mary")
                .peek(name -> System.out.print(" 0." + name)) // Tim, Jim, Peter, Ann, Mary
                .filter(name -> name.length() == 3)
                .peek(name -> System.out.print(" 1." + name)) // Tim, Jim, Ann
                .sorted()                                     // Tim, Jim, Ann (sorted)
                .peek(name -> System.out.print(" 2." + name)) // Ann, Jim
                .limit(2)
                .forEach(name -> System.out.print(" 3." + name)); // Ann, Jimm
    }
}
