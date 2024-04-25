package driver;

import enums.DriverType;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {

    public static WebDriver getDriverByType(DriverType driverType){
        switch (driverType){
            case ANDROID:
                return DriverCreation.createAndroidDriver();

            case IOS:
                return DriverCreation.createIOSDriver();

        }
        throw new RuntimeException("Invalid Choice");
    }
}
