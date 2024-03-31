package org.training.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UsingSets {

    public static void main(String[] args){
        //factoryMethods();
        //treeSet();
        //hashSet();
        linkedHashSet();
    }

    public static void factoryMethods(){
        // unmodifiable sets returned
        Set<String> of = Set.of("a", "b", "c");
        Set<String> copy = Set.copyOf(of);

        of.add("d"); // UnsupportedOperationException
        copy.add("d"); // UnsupportedOperationException

        of.remove("a"); // UnsupportedOperationException
    }

    public static void treeSet(){
        // SUU - Sets are Unique and Unordered
        Set<String> names = new TreeSet<>();
        names.add("John");
        names.add("John");
        names.add("Helen");
        names.add("Anne");
        // No duplicates, elements are sorted alphabetically
        System.out.println(names); // [Anne, Helen, John]

        Set<Integer> numbers = new TreeSet<>();
        numbers.add(23);
        numbers.add(Integer.valueOf("21"));
        numbers.add(Integer.valueOf("11"));
        numbers.add(99);
        // No duplicates, elements are sorted numerically
        System.out.println(numbers); // [11, 21, 23, 99]
    }

    public static void hashSet(){
        // HashSet
        Set<Contact> contactsHS = new HashSet<>();
        contactsHS.add(new Contact(45, "zoe"));
        contactsHS.add(new Contact(45, "zoe")); // "zoe" only added once (set)
        contactsHS.add(new Contact(34, "alice"));
        contactsHS.add(new Contact(35, "andrew"));
        contactsHS.add(new Contact(36, "brian"));
        contactsHS.add(new Contact(37, "carol"));
        /*
            Output:
            Contact{age=45, name='zoe'}
            Contact{age=34, name='alice'}
            Contact{age=35, name='andrew'}
            Contact{age=36, name='brian'}
            Contact{age=37, name='carol'}
         */

        for(Contact contact:contactsHS){
            System.out.println(contact);
        }
        System.out.println();
    }

    public static void linkedHashSet(){
        // LinkedHashSet
        Set<Contact> contactsHS = new LinkedHashSet<>();
        contactsHS.add(new Contact(45, "zoe"));
        contactsHS.add(new Contact(45, "zoe")); // "zoe" only added once (set)
        contactsHS.add(new Contact(34, "alice"));
        contactsHS.add(new Contact(35, "andrew"));
        contactsHS.add(new Contact(36, "brian"));
        contactsHS.add(new Contact(37, "carol"));

        for(Contact contact: contactsHS){
            System.out.println(contact);
        }
    }
}
