package org.training.java21.pattern_matching;

public class PatternMatching {

    public static void whatType(Object o){
        switch(o){ // switch statement does not cover all possible input values
            case String s -> System.out.println("String");
            case Integer i -> System.out.println("Integer");
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognized");
        }

        System.out.println(
                switch(o){ // switch expression does not cover all possible input values
                    case String s -> "String";
                    case Integer i -> "Integer";
                    case null -> "Null";
                    default -> "Not recognized";
                }
        );
    }

    public static void infoOnType(Object o){
        switch (o){
            // Guarded patterns (Java 17, preview) are now replaced by the 'when' clause (Java 19, preview).
            //case String s && s.startsWith("A") -> System.out.println("String beginning with A: " + s);
            //case Integer i && i.intValue() > 10 -> System.out.println("Integer > 10: " + i);
            case String s when s.startsWith("A") -> System.out.println("String beginning with A: " + s);
            case Integer i when i.intValue() > 10 -> System.out.println("Integer > 10: " + i);
            case null -> System.out.println("Null");
            default -> System.out.println("Not recognized");
        }
    }

    public static void main(String[] args){
        whatType("ABC");    // String, String
        whatType(122);      // Integer, Integer
        whatType(null);     // Null, Null
        whatType(32.39);    // Not recognized, Not recognized

        infoOnType("ABC");  // String beginning with A: ABC
        infoOnType("abc");  // Not recognized
        infoOnType(12);     // Integer > 10: 12
        infoOnType(8);      // Not recognized
    }
}
