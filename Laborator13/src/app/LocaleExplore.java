package app;

import com.DisplayLocales;
import com.Info;
import com.SetLocale;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class LocaleExplore {

    public static void main (String[] args){
        SetLocale.currentLocale = Locale.getDefault();
        Scanner keyboard = new Scanner(System.in);

        label:
        while(true){
            ResourceBundle resourceBundle = ResourceBundle.getBundle("res.Messages", SetLocale.currentLocale);
            System.out.println(resourceBundle.getString("prompt"));
            System.out.print(">");
            String message = keyboard.next();
            switch (message) {
                case "DisplayLocales":
                    new DisplayLocales(SetLocale.currentLocale);
                    break;
                case "Info":
                    new Info(SetLocale.currentLocale);
                    break;
                case "SetLocale":
                    System.out.println(resourceBundle.getString("country"));
                    String lcl1 = keyboard.next();
                    System.out.println(resourceBundle.getString("language"));
                    String lcl2 = keyboard.next();
                    new SetLocale(new Locale(lcl2, lcl1));
                    break;
                case "Quit":
                    break label;
                default:
                    System.out.println(resourceBundle.getString("invalid"));
                    break;
            }
        }
    }
}
