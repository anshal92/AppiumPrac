package pages.homePage;

import org.tinylog.Logger;

public class HomePageActions extends HomePageLocator{

    public HomePageActions(){
        String text = actions.elementActions().getText(CREATE_ACCOUNT_BTN);
        Logger.debug("The text is -> "+ text);
    }

    public HomePageActions clickCreateAccountBtn(){
        actions.elementActions().clickElement(CREATE_ACCOUNT_BTN);
        return this;
    }

    public HomePageActions isUserOnGooglePageThenGoBack(){
        try {
            Thread.sleep(7*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        boolean elementVisible = actions.elementActions().isElementVisible(GOOGLE_DEFAULT_LOGIN, 60, 2);
        if(elementVisible) actions.mobileActions().systemBack();
        return this;
    }

    public HomePageActions typeUserData(String fullName){
        actions.elementActions().clickElement(FULL_NAME_FIELD);
        actions.elementActions().sendKeys(FULL_NAME_FIELD, fullName);

        return this;
    }

    public HomePageActions typeUserEmail(String email){
        actions.elementActions().clickElement(EMAIL_FIELD);
        /*try {
            Thread.sleep(7*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        actions.elementActions().clickElement(EMAIL_FIELD);
        actions.elementActions().sendKeys(EMAIL_FIELD, email);
        return this;
    }

    public HomePageActions clickPasswordField(){
        actions.elementActions().clickElement(CREATE_PASSWORD_FIELD);
        return this;
    }

    public HomePageActions typeUserPassword(String password){
        clickPasswordField();
        actions.elementActions().sendKeys(CREATE_PASSWORD_FIELD, password);
        return this;
    }

    public boolean isContinueBtnEnabled(){
        return actions.elementActions().isElementEnabled(CONTINUE_BTN);
    }

    public boolean isContinueClickable(){
        return actions.elementActions().isElementClickAble(CONTINUE_BTN);
    }
    public void clickContinue(){
        actions.elementActions().clickElement(CONTINUE_BTN);
    }

    public boolean isFullNameErrorPresent(){
        return actions.elementActions().isElementVisible(ERROR_MSG_ENTER_FULL_NAME);
    }

    public boolean isEmailErrorPresent(){
        return actions.elementActions().isElementVisible(ERROR_MSG_ENTER_VALID_EMAIL);
    }
}
