package org.training.concurrency;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("run(): " + Thread.currentThread().getName());
    }

    public static void main(String[] args){
        // The Thread constructor requires a Runnable
        new Thread(new MyRunnable()).start();
        System.out.println("main(): " + Thread.currentThread().getName());
    }
}
