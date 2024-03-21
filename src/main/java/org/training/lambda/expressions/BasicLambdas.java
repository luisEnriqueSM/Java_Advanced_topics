package org.training.lambda.expressions;

interface I{
    void m(); // a functional interface i.e. it has only one abstract method
}
public class BasicLambdas {

    public static void main(String[] args){
        // pre-Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m()");
            }
        };
        i.m();

        // Java 8 - Lambda expression
        I lamdaI = () -> {
            System.out.println("Lambda version");
        };
        I lamndaI2 = () -> System.out.println("Lambda version");
        lamdaI.m();
        lamndaI2.m();
    }
}
