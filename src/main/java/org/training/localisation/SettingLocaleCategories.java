package org.training.localisation;

import java.text.NumberFormat;
import java.util.Locale;

public class SettingLocaleCategories {

    public static void main(String[] args){
        double n = 77_000.11;
        Locale locFrench = new Locale("fr", "FR");

        Locale defaultLocale = Locale.getDefault();
        System.out.println(defaultLocale.getDisplayName()); // español (Latinoamérica)
        System.out.println(defaultLocale.getDisplayLanguage()); // español
        System.out.println(defaultLocale.getDisplayCountry()); // Latinoamérica
        System.out.println(NumberFormat.getInstance().format(n)); // 77,000.11

        Locale.setDefault(Locale.Category.DISPLAY, locFrench);
        System.out.println("\nDISPLAY changed: " + defaultLocale.getDisplayName()); // espagnol (Amérique latine)
        System.out.println("DISPLAY changed: " + defaultLocale.getDisplayLanguage()); // espagnol
        System.out.println("DISPLAY changed: " + defaultLocale.getDisplayCountry()); // Amérique latine
        System.out.println("DISPLAY changed: " + NumberFormat.getInstance().format(n)); // 77,000.11

        Locale.setDefault(Locale.Category.FORMAT, locFrench);
        System.out.println("FORMAT changed: \t" + NumberFormat.getInstance().format(n)); // 77 000,11
    }
}
