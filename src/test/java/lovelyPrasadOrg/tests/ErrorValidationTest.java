package lovelyPrasadOrg.tests;

import lovelyPrasadOrg.pageObjects.LoginPage;
import lovelyPrasadOrg.testComponent.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationTest extends BaseTest {
    LoginPage loginPage;
    @BeforeClass
    public void setup() throws IOException {
        launchApp();
        loginPage = new LoginPage(wd);
    }
    @Test
    public void verifyErrorMessage(){
        loginPage.login("lovelyprasad409@gmail.com", "#nkmbnj");
        String ErrorMessage= loginPage.getInvalidUserPassError();
        Assert.assertEquals(ErrorMessage,"Incorrect email or password.");
    }
}
