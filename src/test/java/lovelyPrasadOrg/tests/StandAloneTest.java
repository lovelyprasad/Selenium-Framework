package lovelyPrasadOrg.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class StandAloneTest {
    public static void main(String[] args) throws InterruptedException {
        //downloads latest chromedriver
        WebDriverManager.chromedriver().browserVersion("146").setup();
        WebDriver wd=new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        wd.get("https://rahulshettyacademy.com/client");
        wd.manage().window().maximize();
        wd.findElement(By.id("userEmail")).sendKeys("lovelyprasad409@gmail.com");
        wd.findElement(By.id("userPassword")).sendKeys("#Ramjeeprasad123");
        wd.findElement(By.id("login")).click();
        List<WebElement> products=wd.findElements(By.cssSelector(".mb-3"));
        WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
        WebDriverWait eWait=new WebDriverWait(wd,Duration.ofSeconds(5));
        eWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
        Thread.sleep(1000);
        wd.findElement(By.cssSelector("[routerlink$='cart']")).click();
        List<WebElement> l1=wd.findElements(By.cssSelector(".items .infoWrap"));
        int noOfItems=l1.size();
        Assert.assertEquals(noOfItems,1);
        wd.findElement(By.cssSelector(".totalRow button")).click();

        Actions a =new Actions(wd);
        a.sendKeys(wd.findElement(By.xpath("//div[text()='CVV Code ']/following-sibling::input")),"032").build().perform();
        a.sendKeys(wd.findElement(By.xpath("//div[text()='Name on Card ']/following-sibling::input")),"lovely").build().perform();
        a.sendKeys(wd.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
        eWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".ta-results.list-group button:nth-child(3)"))).click();
        a.moveToElement(wd.findElement(By.cssSelector(".action__submit"))).click().build().perform();
        String aText=wd.findElement(By.xpath(" Thankyou for the order. ")).getText();
        Assert.assertEquals(aText," Thankyou for the order. ");wd.quit();
    }
}
