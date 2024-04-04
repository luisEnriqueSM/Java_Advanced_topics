package org.training.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class VariousTypes {

    public static void main(String[] args){
        // CachedThreadPool
        ExecutorService es = Executors.newCachedThreadPool();

        // FixedThreadPool
        int cpuCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Number of processors: " + cpuCount);
        ExecutorService es2 = Executors.newFixedThreadPool(cpuCount);

        // SingleThreadExecutor
        ExecutorService es3 = Executors.newSingleThreadExecutor();
    }
}
