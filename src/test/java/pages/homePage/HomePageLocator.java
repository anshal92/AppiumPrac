package pages.homePage;

import org.openqa.selenium.By;
import pages.BasePage;

public class HomePageLocator extends BasePage {

    public static final By CREATE_ACCOUNT_BTN = By.xpath("//android.view.View[@content-desc='Create account for free']");

    public static final By GOOGLE_DEFAULT_LOGIN = By.xpath("//android.widget.TextView[@text='with your Google Account.']");

    public static final By CREATE_ACCOUNT_HEADER = By.xpath("//android.view.View[@content-desc='Create an account']");

    public static final By FULL_NAME_FIELD = By.xpath("//android.widget.EditText[1]");////android.widget.ScrollView/android.view.View/android.widget.EditText[1]

    //public static final By FULL_NAME_FIELD_2 = By.xpath("//android.widget.EditText[1]");//android.widget.ScrollView/android.widget.EditText[1]

    public static final By EMAIL_FIELD2 = By.xpath("//android.widget.ScrollView/android.view.View/android.widget.EditText[2]"); ////android.widget.ScrollView/android.view.View/android.widget.EditText[2]
    public static final By EMAIL_FIELD = By.xpath("//android.widget.EditText[2]");////android.widget.ScrollView/android.widget.EditText[2]
    ////android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ScrollView/android.widget.ScrollView/android.widget.EditText[2]

    public static final By CREATE_PASSWORD_FIELD = By.xpath("//android.widget.EditText[3]");
    //w/android.widget.ScrollView/android.widget.EditText[3]

    public static final By CONTINUE_BTN = By.xpath("//android.view.View[@content-desc='Continue']");

    public static final By SIGNUP_HELP_BTN = By.xpath("//android.view.View[@content-desc='Help']");

    public static final By ERROR_MSG_ENTER_FULL_NAME = By.xpath("//android.view.View[@content-desc='Please enter full name']");

    public static final By ERROR_MSG_ENTER_VALID_EMAIL= By.xpath("//android.view.View[@content-desc='Please enter valid email']");


}
