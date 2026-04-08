package lovelyPrasadOrg.abstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitPage {
    WebDriver wd;
    public WaitPage(WebDriver wd)
    {
        this.wd=wd;
    }

    public void waitForElementToAppear(By locatorToWaitFor)
    {
        WebDriverWait eWait=new WebDriverWait(wd, Duration.ofSeconds(5));
        eWait.until(ExpectedConditions.visibilityOfElementLocated(locatorToWaitFor));
    }
    public void waitForElementToDisappear(By locatorToWaitFor)
    {
        WebDriverWait eWait=new WebDriverWait(wd, Duration.ofSeconds(5));
        eWait.until(ExpectedConditions.invisibilityOfElementLocated(locatorToWaitFor));
    }
    public void waitForElementToBeClickable(By locatorToWaitFor)
    {
        WebDriverWait eWait=new WebDriverWait(wd, Duration.ofSeconds(5));
        eWait.until(ExpectedConditions.elementToBeClickable(locatorToWaitFor));
    }
}
