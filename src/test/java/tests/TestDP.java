package tests;

import enums.TestCaseType;
import org.testng.annotations.DataProvider;

public class TestDP extends BaseTestPage{

    @DataProvider(name = "testData", parallel = true)
    public Object[][] testData(){
        String correctEmail = "abcxyz@gmail.com";
        String correctName = "Test T";
        String correctPass = "Test12345";

        return new Object[][]{
                {TestCaseType.EMAIL_INCORRECT, correctName, "aaabbb@", correctPass},
                {TestCaseType.NAME_INCORRECT, "Teest", correctEmail, correctPass},
                {TestCaseType.PASSWORD_INCORRECT, correctName, correctEmail, "yoooooooooo"},
                {TestCaseType.ALLCORRECT, correctName, correctEmail, correctPass}
        };
    }
}
