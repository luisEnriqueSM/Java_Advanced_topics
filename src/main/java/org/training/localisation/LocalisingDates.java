package org.training.localisation;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalisingDates {

    public static void main(String[] args){
        Locale locUS = Locale.US;  // en_US
        Locale locFrench = new Locale("fr", "FR"); // fr_FR
        Locale locGerman = Locale.GERMANY; // de_DE

        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt); // 2024-04-04T13:48:23.252946

        DateTimeFormatter dateMediumStyle = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        // Using the United States locale (en_US)
        System.out.println(dateMediumStyle.withLocale(locUS).format(ldt)); // Apr 4, 2024
        // Using the French locale
        System.out.println(dateMediumStyle.withLocale(locFrench).format(ldt)); // 4 avr. 2024

        DateTimeFormatter timeShortStyle = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        // Using the United States locale (en_US)
        System.out.println(timeShortStyle.withLocale(locUS).format(ldt)); // 1:55 PM
        // Using the German locale
        System.out.println(timeShortStyle.withLocale(locGerman).format(ldt)); // 13:53

        DateTimeFormatter dateTimeShortStyle = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        // Using the default locale (en_IE)
        System.out.println(dateTimeShortStyle.format(ldt)); // 4/4/24, 13:54
        // Using the United States locale (es_US)
        System.out.println(dateTimeShortStyle.withLocale(locUS).format(ldt)); // 4/4/24, 1:55 PM
    }
}
