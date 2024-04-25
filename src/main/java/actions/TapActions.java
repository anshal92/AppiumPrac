package actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SmartWait;

public class TapActions {
    AndroidDriver androidDriver;

    public TapActions(WebDriver driver){
        androidDriver = (AndroidDriver) driver;
    }

    public void tapOnElement(By locator){
        WebElement element = SmartWait.defaultWaitForElementToBeVisible(androidDriver, locator);

    }
}
