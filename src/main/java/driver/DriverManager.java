package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    public static final ThreadLocal<WebDriver> THREAD_LOCAL_DRIVER = new ThreadLocal<>();

    public static WebDriver getThreadLocalDriver(){
        return THREAD_LOCAL_DRIVER.get();
    }

    public static void setThreadLocalDriver(WebDriver webDriver){
        THREAD_LOCAL_DRIVER.set(webDriver);
    }

    public static void unLoadThreadLocalDriver(){
        THREAD_LOCAL_DRIVER.remove();
    }
}
