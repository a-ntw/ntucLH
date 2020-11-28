package localeex;

import java.util.Locale;

public class LocaleEx {

    public static void main(String[] args) {

        Locale locale = Locale.getDefault();

            System.out.println(" Country : " + locale.getDisplayCountry());
            
            System.out.println(" Display Language : " + locale.getDisplayLanguage());
            
            System.out.println(" Display Name : " + locale.getDisplayName());
            
            System.out.println(" ISO Country Code : " + locale.getISO3Country());
            
            System.out.println(" ISO Lang Code : " + locale.getISO3Language());
            
            System.out.println(" Langauge : " + locale.getLanguage());
            
            System.out.println(" Country : " + locale.getCountry());
            
                
    }
    
}
