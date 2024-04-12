package org.training.java21.record_patterns;

public class TestRecords {

    public static void main(String[] args){
        records();
    }

    public static void records(){
        Person p1 = new Person("Luis Enrique", 28);
        System.out.println(p1);         // Person[name=Luis Enrique, age=28]
        System.out.println(p1.name() + "; " + p1.age()); // Luis Enrique; 28
        patternMatching(p1);             // PM: Luis Enrique; 28
        patternMatching("abc");

        Pair<String> pairS = new Pair<>("Luis", "Enrique");
        Pair<Integer> pairI = new Pair<>(10,20);
        patternMatching(pairS);     // PM: Luis; Enrique
        patternMatching(pairI);     // PM: Luis; Enrique
    }

    public static void patternMatching(Object obj){
        // "Person person" is a "type pattern". At runtime, "pattern matching" is
        // performed by instanceof to see if "obj" is referring to a Person object;
        // is so, "person" is made to refer to that Person object
        if(obj instanceof Person person){
            System.out.println("PM: " + person.name() + "; " + person.age());
        } else if(obj instanceof Pair pair){
            System.out.println("PM: " + pair.x() + "; " + pair.y());
        }
    }
}
