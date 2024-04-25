package tests;

import listeners.SuiteListener;
import listeners.TestListener;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class, SuiteListener.class})
public class BaseTestPage {
}
