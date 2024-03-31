package org.training.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args){
        //searchStrings();
        searchCats();
    }

    public static void searchStrings(){
        List<String> names = Arrays.asList("John", "Martin", "Paula", "Ann");
        Collections.sort(names); // natural order sort - alphabetic for String
        System.out.println(names); // [Ann, John, Martin, Paula]
        // if found, return index
        System.out.println(Collections.binarySearch(names, " ")); // 1
        // if not found, return : -(indexItWouldHaveIfPresent) -1
        // "Laura" this is: -(2) - 1 = -2 -1 = -3
        System.out.println(Collections.binarySearch(names, "Laura")); // -3
    }

    public static void searchCats(){
        Cat fluffy = new Cat("Fluffy", 1);
        Cat bella = new Cat("Bella", 5);
        List<Cat> catList = Arrays.asList(fluffy, bella);

        Collections.sort(catList); // must sort first by natural order - name ascending
        System.out.println(catList); // [Cat{name='Bella', age=5}, Cat{name='Fluffy', age=1}]

        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella)); // 0

        // set up the Comparator<T>
        //      int compare(T o1, T o2)
        Comparator<Cat> byAge = (cat1, cat2) -> cat1.getAge() - cat2.getAge();
        Collections.sort(catList, byAge); // sort by age ascending
        System.out.println(catList); // [Cat{name='Fluffy', age=1}, Cat{name='Bella', age=5}]
        System.out.println("Bella is at index: " + Collections.binarySearch(catList, bella, byAge));
    }
}
