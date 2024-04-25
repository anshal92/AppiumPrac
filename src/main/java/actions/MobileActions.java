package actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;

public class MobileActions {
    AppiumDriver appiumDriver;

    public MobileActions(WebDriver driver){
        appiumDriver = (AppiumDriver) driver;
    }

    public void systemBack(){
        appiumDriver.navigate().back();
    }
}
