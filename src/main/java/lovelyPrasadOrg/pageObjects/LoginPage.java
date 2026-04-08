package lovelyPrasadOrg.pageObjects;

import lovelyPrasadOrg.abstractComponents.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends WaitPage {
    WebDriver wd;
    public LoginPage(WebDriver wd)
    {
        super(wd);
        this.wd=wd;
        PageFactory.initElements(wd,this);
    }
    //WebElement username= wd.findElement(By.id("userEmail"));
   @FindBy(id="userEmail")
   WebElement usernameTextBox;
   @FindBy(id="userPassword")
   WebElement passwordTextBox;
   @FindBy(id="login")
   WebElement loginButton;

   public void login(String userName,String password)
   {
       usernameTextBox.sendKeys(userName);
       passwordTextBox.sendKeys(password);
       loginButton.click();
   }
   public void goToURL()
   {
       wd.get("https://rahulshettyacademy.com/client");
   }
    @FindBy(css=".toast-message")
    WebElement incorrectUserPass;
    public String getInvalidUserPassError()
    {
        waitForElementToAppear(By.cssSelector(".toast-message"));
        return incorrectUserPass.getText();
    }


}
