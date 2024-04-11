package org.training.java21;

public class TestRecordPatterns {

    public static void main(String[] args){
        recordPattern();
    }

    public static void recordPattern(){
        Person p1 = new Person("Luis Enrique", 28);
        Person p2 = new Person("Nico", 30);
        //nonNesting(p1);     // Luis Enrique; 28
        //nonNesting(p2);     // Nico; 30

        Player player1 = new Player(p1, Ability.WEAK);
        Player player2 = new Player(p2, Ability.STRONG);
        Doubles dbles = new Doubles(player1, player2);
        nesting(dbles);
    }

    public static void nonNesting(Object obj){
        // Person(String s, Integer nAge) is a "record pattern" which does 2 things:
        // 1. Tests whether the object is of type Person(as usual)
        // 2. Extracts the records components by invoking the component accessor
        //      methods on our behalf.
        if(obj instanceof Person(String s, Integer nAge)){ // record pattern
            System.out.println(s + "; " + nAge);
        }
    }

    public static void nesting(Doubles dbles){
        // straightforward nesting
        //if(dbles instanceof Doubles(var pl1, var pl2)){ // LVTI(Local Variable Type Inference) works also
        if(dbles instanceof Doubles(Player pl1, Player pl2)){
            System.out.println(pl1.person() + "; " + pl1.ability()); // Person[name=Luis Enrique, age=28]; WEAK
        }
        // more complex nesting
        //if(dbles instanceof Doubles(Player(var pl1, var ability), var pl2)){ // LVTI(Local Variable Type Inference) works also
        if(dbles instanceof Doubles(Player(Person pl1, Ability ability), Player pl2)){
            System.out.println(pl1.name() + "; " + pl1.age() + "; " + ability.name()); // Luis Enrique; 28; WEAK
        }
    }

}
