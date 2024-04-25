package listeners;

import driver.DriverFactory;
import driver.DriverManager;
import enums.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tinylog.Logger;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        Logger.debug("---XXX On Test Start XXX---");
        List<String> parameters = getDataProviderParameters(result);
        System.out.println("All parameter are -> "+ parameters);

        try {
            System.out.println("Running UI Test. Driver creation started...");
            WebDriver driver = DriverFactory.getDriverByType(DriverType.ANDROID);
            System.out.println("Setting driver -> "+ driver.toString() +" on DriverManager");
            DriverManager.setThreadLocalDriver(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Logger.debug("---XXX On Test Success XXX---");
        try {
            System.out.println("Running UI Test. Driver quiting and unloading started...");
            DriverManager.getThreadLocalDriver().quit();
            DriverManager.unLoadThreadLocalDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Logger.debug("---XXX On Test Failure XXX---");
        try {
            System.out.println("Running UI Test. Driver quiting and unloading started...");
            DriverManager.getThreadLocalDriver().quit();
            DriverManager.unLoadThreadLocalDriver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Logger.debug("---XXX On Test Skipped XXX---");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Logger.debug("---XXX On Test FailedButWithinSuccessPercentage XXX---");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        Logger.debug("---XXX On Test FailedWithTimeout XXX---");
    }

    @Override
    public void onStart(ITestContext context) {
        Logger.debug("---XXX On Start XXX---");
    }

    @Override
    public void onFinish(ITestContext context) {
        Logger.debug("---XXX On Finish XXX---");
    }

    private List<String> getDataProviderParameters(ITestResult result){
        return Arrays.stream(result.getParameters()).map(obj -> String.valueOf(obj)).collect(Collectors.toList());
    }
}
