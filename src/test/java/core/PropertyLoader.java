package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROPERTY_FILE = "D:\\Lessons_Selenium_Bionics\\loanNSTautotest\\src\\resources\\application.properties";

    public static String loadProperty (String name){

        Properties props = new Properties();
        String value = "";

        try{
            FileInputStream link = new FileInputStream(PROPERTY_FILE);
            props.load(link);
            link.close();
        }catch (IOException e){
            System.out.println("ОШИБКА: Файл свойств отсуствует!");
        }

        if (name != null){
            value = props.getProperty(name);
        }
        return value;
    }
}
