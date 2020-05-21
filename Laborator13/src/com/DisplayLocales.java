package com;

import java.util.Locale;
import java.util.ResourceBundle;

public class DisplayLocales {
    public DisplayLocales(Locale locale) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.Messages",locale);
        Locale[] available = Locale.getAvailableLocales();

        System.out.println(resourceBundle.getString("locales"));
        for (Locale locale1 : available) {
            System.out.println(locale1.getCountry()+ " " + locale1.getLanguage());
        }
    }
}
