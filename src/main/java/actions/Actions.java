package actions;

import driver.DriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Actions {

    private final WebDriver driver;

    public Actions(){
        driver = DriverManager.getThreadLocalDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public ElementActions elementActions(){
        return new ElementActions(driver);
    }

    public MobileActions mobileActions(){
        return new MobileActions(driver);
    }

    public TapActions tapActions(){
        return new TapActions(driver);
    }
}
