package listeners;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.xml.XmlSuite;
import org.tinylog.Logger;
import utils.FileUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SuiteListener implements ISuiteListener {
    AppiumServiceBuilder builder;
    @Override
    public void onStart(ISuite suite) {
        Logger.debug("On Suite Start");
        FileUtils.getPropertiesAndSetAsSystemProps("AppiumProperties.config");
        Map<String,String> paths = new HashMap<>();
        paths.put("ANDROID_HOME",System.getProperty("default.androidHome")); //ANDROID_HOME local path
        paths.put("ANDROID_SDK_ROOT",System.getProperty("default.androidSdkRoot")); //ANDROID_SDK_ROOT local path
        paths.put("JAVA_HOME",System.getProperty("default.javaHome")); // JAVA_HOME  local path

        builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0").usingPort(4723)
                .withAppiumJS(new File("/usr/local/bin/appium/"))
                .withEnvironment(paths);

        AppiumDriverLocalService.buildService(builder).start();

        suite.getXmlSuite().setThreadCount(1);
        suite.getXmlSuite().setParallel(XmlSuite.ParallelMode.METHODS);
        suite.getXmlSuite().setDataProviderThreadCount(1);
        Logger.debug("The XML is -> "+ suite.getXmlSuite().toXml());


    }

    @Override
    public void onFinish(ISuite suite) {
        Logger.debug("On Suite Finish");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AppiumDriverLocalService.buildService(builder).stop();
    }
}
