package lovelyPrasadOrg.pageObjects;

import lovelyPrasadOrg.abstractComponents.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends WaitPage {
    WebDriver wd;
    public ConfirmationPage(WebDriver wd)
    {
        super(wd);
        this.wd=wd;
        PageFactory.initElements(wd,this);
    }
    @FindBy(xpath ="//h1[text()=' Thankyou for the order. ']")
    WebElement confirmation_message;
    public String getConfirmationMessage() throws InterruptedException {
        //waitForElementToAppear(By.xpath("//h1[text()='Thankyou for the order.']"));
        return confirmation_message.getText();

    }
}
