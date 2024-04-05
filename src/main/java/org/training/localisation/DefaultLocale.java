package org.training.localisation;

import java.util.Locale;

public class DefaultLocale {

    public static void main(String[] args){
        Locale locale = Locale.getDefault();
        System.out.println(locale); // es_419  <- america latina
    }
}
