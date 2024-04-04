package org.training.concurrency;

public class UsingLambdaAsRunnable {

    public static void main(String[] args){
        Thread t = new Thread( () -> System.out.println("run(): " + Thread.currentThread().getName()));
        t.start();
        //t.run(); // There is no new Thread create it. It will be at the same main Thread
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}
