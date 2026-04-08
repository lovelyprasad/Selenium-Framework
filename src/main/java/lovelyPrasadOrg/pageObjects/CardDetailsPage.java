package lovelyPrasadOrg.pageObjects;

import lovelyPrasadOrg.abstractComponents.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CardDetailsPage extends WaitPage {
    WebDriver wd;
    public CardDetailsPage(WebDriver wd)
    {
        super(wd);
        this.wd=wd;
        PageFactory.initElements(wd,this);
    }
    @FindBy(xpath = "//div[text()='CVV Code ']/following-sibling::input")
    WebElement cvv_textBox;
    @FindBy(xpath = "//div[text()='Name on Card ']/following-sibling::input")
    WebElement nameOnCard_textBox;
    @FindBy(css=".action__submit")
    WebElement submit;
    @FindBy(xpath = "//input[@placeholder='Select Country']")
    WebElement country_textBox;
    @FindBy(css=".ta-results.list-group button:nth-child(3)")
    WebElement selectCountry;

    public void enterCvv(String cvv)
    {
        Actions a=new Actions(wd);
        a.sendKeys(cvv_textBox,cvv).build().perform();
    }
    public void enterNameOnCard(String nameOnCard)
    {
        Actions a=new Actions(wd);
        a.sendKeys(nameOnCard_textBox,nameOnCard).build().perform();
    }
    public void enterAndSelectCountry(String country)
    {
        Actions a=new Actions(wd);
        a.sendKeys(country_textBox,country).build().perform();
        waitForElementToBeClickable(By.cssSelector(".ta-results.list-group button:nth-child(3)"));
        selectCountry.click();
    }
    public void clickSubmit()
    {
        submit.click();
    }

//     a.sendKeys(wd.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input")),"032").build().perform();
//        a.sendKeys(wd.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")),"lovely").build().perform();
//        a.sendKeys(wd.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
}
