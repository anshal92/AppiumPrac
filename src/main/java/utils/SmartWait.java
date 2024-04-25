package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumFluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class SmartWait {
    public static final int DEFAULT_TIMEOUT_SEC = 30;
    public static final int DEFAULT_POLLING_SEC = 1;

    public static WebElement defaultWaitForElementToBePresent(AppiumDriver driver, By locator){
        Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_SEC))
                .pollingEvery(Duration.ofSeconds(DEFAULT_POLLING_SEC))
                .ignoring(NoSuchElementException.class);

        return appiumFluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement waitForElementToBePresent(AppiumDriver driver, By locator, int timeoutSeconds, int pollingTimeSecond){
        Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingTimeSecond))
                .ignoring(NoSuchElementException.class);

        return appiumFluentWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static WebElement defaultWaitForElementToBeVisible(AppiumDriver driver, By locator){
        Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_SEC))
                .pollingEvery(Duration.ofSeconds(DEFAULT_POLLING_SEC))
                .ignoring(NoSuchElementException.class);

        return appiumFluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForElementToBeVisible(AppiumDriver driver, By locator, int timeoutSeconds, int pollingTimeSecond){
        Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(timeoutSeconds))
                .pollingEvery(Duration.ofSeconds(pollingTimeSecond))
                .ignoring(NoSuchElementException.class);

        return appiumFluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean isElementVisible(AppiumDriver driver, By locator){
        boolean isElementVisible;
        try {
            Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT_SEC))
                    .pollingEvery(Duration.ofSeconds(DEFAULT_POLLING_SEC))
                    .ignoring(NoSuchElementException.class);
            appiumFluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            isElementVisible = true;
        }catch (Exception e){
            isElementVisible = false;
        }
        return isElementVisible;
    }

    public static boolean isElementVisible(AppiumDriver driver, By locator, int timeoutSeconds, int pollingTimeSecond){
        boolean isElementVisible;
        try {
            Wait<AppiumDriver> appiumFluentWait = new AppiumFluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(timeoutSeconds))
                    .pollingEvery(Duration.ofSeconds(pollingTimeSecond))
                    .ignoring(NoSuchElementException.class);
            appiumFluentWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            isElementVisible = true;
        }catch (Exception e){
            isElementVisible = false;
        }
        return isElementVisible;
    }
}
