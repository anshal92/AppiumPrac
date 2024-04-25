package actions;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.SmartWait;

public class ElementActions {

    AppiumDriver appiumDriver;

    public ElementActions(WebDriver driver){
        appiumDriver = (AppiumDriver) driver;
    }

    public String getText(By locator){
        return SmartWait.defaultWaitForElementToBeVisible(appiumDriver, locator).getText();
    }

    public String getText(By locator, int pollingTimeSeconds, int timeoutSeconds){
        return SmartWait.waitForElementToBeVisible(appiumDriver, locator, timeoutSeconds, pollingTimeSeconds).getText();
    }

    public void clickElement(By locator){
        SmartWait.defaultWaitForElementToBeVisible(appiumDriver, locator).click();
    }

    public void clickElement(By locator, int pollingTimeSeconds, int timeoutSeconds){
        SmartWait.waitForElementToBeVisible(appiumDriver, locator, timeoutSeconds, pollingTimeSeconds).click();
    }

    public boolean isElementVisible(By locator){
        return SmartWait.isElementVisible(appiumDriver, locator);
    }

    public boolean isElementVisible(By locator, int totalTimeout, int pollingTime){
        return SmartWait.isElementVisible(appiumDriver, locator, totalTimeout, pollingTime);
    }

    public void sendKeys(By locator, String dataToType){
        //WebElement element = SmartWait.defaultWaitForElementToBeVisible(appiumDriver, locator);

        appiumDriver.findElement(locator).sendKeys(dataToType);
    }

    public boolean isElementEnabled(By locator){
        return appiumDriver.findElement(locator).isEnabled();
    }

    public boolean isElementClickAble(By locator){
        return appiumDriver.findElement(locator).getAttribute("clickable").equals("true");
    }

}
