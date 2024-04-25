package driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverCreation {

    public static AndroidDriver createAndroidDriver(){
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options
                .setDeviceName(System.getProperty("default.deviceName","emulator-5554"))
                .setPlatformVersion(System.getProperty("default.version","13.0"))
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setNoReset(false)
                .setAdbExecTimeout(Duration.ofSeconds(60))
                .setApp("/Users/anshal/IdeaProjects/AppiumPrac/src/test/resources/apk/com.coindcx.btc.apk")
                .setAppPackage("com.coindcx.btc");
        try {
            return new AndroidDriver(new URL("http://127.0.0.1:4723"),uiAutomator2Options);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static IOSDriver createIOSDriver(){
        XCUITestOptions xcuiTestOptions = new XCUITestOptions();
        xcuiTestOptions.setNoReset(false)
                .setBundleId("com.apple.MobileAddressBook")
                .setDeviceName("SimulatorIos")
                .setPlatformVersion("17.2")
                .setCommandTimeouts(Duration.ofSeconds(60));
        try {
            return new IOSDriver(new URL("http://127.0.0.1:4723"),xcuiTestOptions);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
