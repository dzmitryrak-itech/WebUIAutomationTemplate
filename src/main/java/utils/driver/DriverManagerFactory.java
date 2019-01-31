package utils.driver;

public class DriverManagerFactory {

    public static DriverManager getManager(String driverType) {

        DriverManager driverManager;

        DriverType type = DriverType.valueOf(driverType.toUpperCase());

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
