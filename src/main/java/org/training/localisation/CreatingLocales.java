package org.training.localisation;

import java.util.Locale;

public class CreatingLocales {

    public static void main(String[] args){
        // 1. Constructors
        System.out.println(new Locale("en"));                  // en
        Locale locEnglishGB = new Locale("en", "GB");  // en_GB
        System.out.println(locEnglishGB.getDisplayLanguage());         // inglés
        System.out.println(locEnglishGB.getDisplayCountry());          // Reino Unido

        // 2. Built-in constants
        System.out.println(Locale.FRENCH);                              // fr
        Locale locFrenchFrance = Locale.FRANCE;                         // fr_FR
        System.out.println(locFrenchFrance.getDisplayLanguage());       // francés
        System.out.println(locFrenchFrance.getDisplayCountry());        // Francia

        // 3. Locale.Builder() pattern
        Locale locArabicEgypt = new Locale.Builder() // ar_EG
                .setRegion("KW")    // country first
                .setLanguage("ar")  // language second
                .build();
        System.out.println(locArabicEgypt); // ar_KW
    }
}
