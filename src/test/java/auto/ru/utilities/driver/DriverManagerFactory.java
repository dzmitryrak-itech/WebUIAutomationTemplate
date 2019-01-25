package auto.ru.utilities.driver;

public class DriverManagerFactory {

    public static DriverManager getManager() {

        DriverManager driverManager;

        //TODO read from property file
        DriverType type = DriverType.valueOf("Android".toUpperCase());

        switch (type) {
            case ANDROID:
                driverManager = new AndroidDriverManager();
                break;
            case IOS:
                driverManager = new IOSDriverManager();
                break;
            default:
                driverManager = new AndroidDriverManager();
                break;
        }
        return driverManager;
    }
}
