package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {

    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String propertyFilePath = System.getProperty("user.dir") + "\\src\\main\\resources\\application.properties";
    private static Properties prop;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    private void loadData() {
        prop = new Properties();

        try {
            prop.load(new FileInputStream(propertyFilePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String get(String propertyName){
        return prop.getProperty(propertyName);
    }
}
