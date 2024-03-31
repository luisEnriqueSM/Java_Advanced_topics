package org.training.generics;

class Foo{
    private int fooValue;

    Foo(int val){
        fooValue = val;
    }

    int getFooValue(){
        return fooValue;
    }

    @Override
    public boolean equals(Object o) {
        // && short-circuits if 'o' is not of type Foo and therefore the downcast
        // will never generate a ClassCastException
        if((o instanceof Foo) && ((Foo) o ).getFooValue() == this.fooValue){
            return true;
        }else{
            return false;
        }
        // on one line:
        // return (o instanceof Foo) && (((Foo) o ).getFooValue() == this.fooValue);
    }
}
public class EqualsTest {
    public static void main(String[] args){
        Foo f1 = new Foo(2);
        Foo f2 = new Foo(2);
        System.out.println(f1.equals(f2)); // true
        System.out.println(f1.equals("SK")); // false (no ClassCastException)
    }
}
