package org.training.java11.privateInterfaceMethods;


// Why 'private' interface methods?
// 1. Reduce code duplications
// 2. Improves encapsulation by hiding implementation details
interface InefficientTennis{ // lots of code duplications
    static void forehand(){
        System.out.println("Move into position");
        System.out.println("Hitting a forehand");
        System.out.println("Move back into ready position");
    }

    default void backhand(){
        System.out.println("Move into position");
        System.out.println("Hitting a backhand");
        System.out.println("Move back into ready position");
    }

    default void smash(){
        System.out.println("Move into position");
        System.out.println("Hitting a smash");
        System.out.println("Move back into ready position");
    }
}

// Note: if 'hit' is simply 'private' and not 'private static' then 'forehand()' has an issue.
//      This is the same as with classes (what I call the I.S. rule) - instance to static is ok
//      but not the other way around.
interface Tennis{
    private static void hit(String stroke){
        System.out.println("Move into position");
        System.out.println("Hitting a " + stroke);
        System.out.println("Move back into ready position");
    }
    static void forehand(){ hit("forehand"); } // form a static method - ok
    default void backhand(){ hit("backhand"); } // form a default method - ok
    private void smash(){ hit(""); }            // from another private method - ok
    default void anotherMethod(){}

    // void volley() { hit("forehand") }    // abstract methods cannot have a method body
}

class ProfessionalTennis implements Tennis{}

public class PrivateInterfaceMethods {
    public static void main(String[] args){
        // The 'hit()' method is hidden/inaccessible i.e. the underlying implementation is hidden
        // from the user of the interface
        Tennis tennis = new ProfessionalTennis();
        tennis.backhand();
        tennis.anotherMethod();
        Tennis.forehand();
    }
}
