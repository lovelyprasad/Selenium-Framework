package lovelyPrasadOrg.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage {
    WebDriver wd;
    public CheckOutPage(WebDriver wd)
    {
        this.wd=wd;
        PageFactory.initElements(wd,this);
    }
    @FindBy(css=".totalRow button")
    WebElement checkOut_Button;
    public void clickCheckout()
    {
        checkOut_Button.click();
    }

}
