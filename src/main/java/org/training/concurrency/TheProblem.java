package org.training.concurrency;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TheProblem {

    public static void main(String[] args){
        usingConcurrentHashMap();
        //usingKeySetIterator();
    }

    public static void usingConcurrentHashMap(){
        //Map<String, String> capitalCities = new HashMap<>();
        Map<String, String> capitalCities = new ConcurrentHashMap<>(); // use this to avoid ConcurrentModificationException
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");
        System.out.println("Before: " + capitalCities);
        for(String key: capitalCities.keySet()){
            System.out.println(key + " is the capital of " + capitalCities.get(key));
            capitalCities.remove(key); // ConcurrentModificationException
        }
        System.out.println("After: " + capitalCities);
    }

    public static void usingKeySetIterator(){
        Map<String, String> capitalCities = new HashMap<>();
        capitalCities.put("Oslo", "Norway");
        capitalCities.put("Copenhagen", "Denmark");
        System.out.println("Before: " + capitalCities);
        for(var iter = capitalCities.keySet().iterator(); iter.hasNext();){
            var key = iter.next();
            System.out.println(key + " is the capital of " + capitalCities.get(key));
            iter.remove();
        }
        System.out.println("After: " + capitalCities);
    }
}
