package org.training.generics;

import java.util.HashMap;
import java.util.Map;

class GenericContact{
    private int age;
    private String name;

    GenericContact(String name, int age){
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode(){ // both instance variables 'age' and 'name' are used
        int hash = 7;
        hash = 89 * hash + this.age;
        hash = 89 * hash + this.name.length(); // a weak algorithm - demo purposes
        return hash;
    }

    @Override
    public boolean equals(Object obj){ // same instance variables used as in equals()!
        if(obj instanceof GenericContact){
            GenericContact otherGenericContact = (GenericContact) obj;
            return this.name.equals(otherGenericContact.name) && this.age == otherGenericContact.age;
        }
        return false;
    }

    @Override
    public String toString(){
        return name + ", " + age;
    }
}
public class ContactTest {

    private static Map<GenericContact, String> map = new HashMap<>();

    public static void main(String[] args){
        GenericContact luis = new GenericContact("luis", 28);
        GenericContact nicolas = new GenericContact("nicolas", 28);
        System.out.println("luis.hashCode() is " + luis.hashCode()); // 57943
        System.out.println("nico.hashCode() is " + nicolas.hashCode()); // 57946
        map.put(luis, "mexican");
        map.put(nicolas, "mexican");
        System.out.println(map.get(luis)); // mexican
        System.out.println(map.get(nicolas)); // mexican

        GenericContact mary = new GenericContact("mary", 21);
        System.out.println("mary.hashCode() is " + mary.hashCode()); // 57320
        map.put(mary, "engineer");
        otherScope();
        System.out.println("After otherScope(): " + map.get(mary)); // accountant

        testJane();
        // HashMaps do not maintain order
        System.out.println(map); //
    }

    public static void otherScope(){
        GenericContact anotherMary = new GenericContact("mary", 21); // reconstruct "anotherMary"
        System.out.println("anotherMary.hashCode() is " + anotherMary.hashCode()); // 57320
        // Separate object used as a key to access the Map!
        System.out.println("In otherScope(): " + map.get(anotherMary)); // engineer

        // the next line overwrites mary with anotherMary as a key because:
        //      a) their hashCode are the same
        //      b) they are both equal according to equals()
        map.put(anotherMary, "accountant");
    }

    public static void testJane(){
        // "jane" will result in the same hashcode as "mary" or "anotherMary"
        // because their ages are the same and "mary" and "jane" each have
        // 4 letters. Thus, the hashing algorithm will find the same bucket.
        // The equals() method now however finds a different key because we are
        // searching based on "jane" within the bucket and not for "mary" as above.
        // As a result, when we do the "get", we get "nurse" and not "accountant".
        GenericContact jane = new GenericContact("jane", 21);
        System.out.println("jane.hashCode() is " + jane.hashCode() ); //57320
        map.put(jane, "nurse");
        System.out.println(map.get(jane)); // nurse
    }
}
