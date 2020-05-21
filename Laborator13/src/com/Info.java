package com;

import java.text.DateFormatSymbols;
import java.text.NumberFormat;
import java.util.*;

public class Info {

    public Info(Locale locale) {

        ResourceBundle resourceBundle = ResourceBundle.getBundle("res.Messages",locale);
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        nf.setCurrency(Currency.getInstance(locale));
        DateFormatSymbols dfs = new DateFormatSymbols(locale);
        String[] weekdays = dfs.getWeekdays();
        String[] months = dfs.getMonths();

        System.out.println(resourceBundle.getString("info"));
        System.out.println("Country: " + locale.getDisplayCountry());
        System.out.println("Language: "+ locale.getDisplayLanguage());
        System.out.println("Currency: " + nf.getCurrency().getDisplayName());
        System.out.println("Week days :" + Arrays.toString(weekdays));
        System.out.println("Months :" + Arrays.toString(months));
        System.out.println("Today: " + java.time.ZonedDateTime.now());
    }
}
