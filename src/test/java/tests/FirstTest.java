package tests;

import driver.DriverFactory;
import enums.DriverType;

import enums.TestCaseType;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.tinylog.Logger;
import pages.homePage.HomePageActions;


public class FirstTest extends TestDP {

    @Test(dataProvider = "testData") //
    public void firstTest(TestCaseType caseType, String name, String email, String passWord) {
        Logger.debug("XXX Running the scenario -> " + caseType.toString());
        HomePageActions homePageActions = new HomePageActions().clickCreateAccountBtn()
                .isUserOnGooglePageThenGoBack();


        switch (caseType) {
            case ALLCORRECT:
                homePageActions.typeUserData(name)
                        .typeUserEmail(email)
                        .typeUserPassword(passWord);
                Assert.assertTrue(homePageActions.isContinueClickable(), "Issue!!! Continue btn is not enabled for " + caseType);
                homePageActions.clickContinue();
                break;
            case EMAIL_INCORRECT:
                homePageActions.typeUserData(name)
                        .typeUserEmail(email)
                        .clickPasswordField();
                Assert.assertFalse(homePageActions.isContinueClickable(), "Issue!!! Continue btn is enabled for " + caseType);
                Assert.assertTrue(homePageActions.isEmailErrorPresent(), "Issue!!! Email Error message not present");
                break;
            case NAME_INCORRECT:
                homePageActions.typeUserData(name)
                        .typeUserEmail(email);
                Assert.assertFalse(homePageActions.isContinueClickable(), "Issue!!! Continue btn is enabled for " + caseType);
                Assert.assertTrue(homePageActions.isFullNameErrorPresent(), "Issue!!! Full Name Error message not present");
                break;
            case PASSWORD_INCORRECT:
                homePageActions.typeUserData(name)
                        .typeUserEmail(email)
                        .typeUserPassword(passWord);
                Assert.assertFalse(homePageActions.isContinueClickable(), "Issue!!! Continue btn is enabled for " + caseType);
                break;
        }


    }

//    @Test
//    public void secondTest(){
//        DriverFactory.getDriverByType(DriverType.IOS);
//
//        String eleXpath = "//android.widget.TextView[@resource-id='android:id/title' and @text='Network & internet']";
//
//        driver.findElement(By.xpath(eleXpath)).click();
//    }
}
