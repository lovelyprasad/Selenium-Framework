package lovelyPrasadOrg.testComponent;

import io.github.bonigarcia.wdm.WebDriverManager;
import lovelyPrasadOrg.pageObjects.LoginPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    public WebDriver wd;
    public WebDriver initializeDriver() throws IOException {
        Properties properties=new Properties();
        FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//java//lovelyPrasadOrg//resources//globalRuntime.properties");
        properties.load(fis);
        String currentBrowser=properties.getProperty("browser");
        if(currentBrowser.equalsIgnoreCase("chrome"))
        {
        WebDriverManager.chromedriver().browserVersion("146").setup();
        wd = new ChromeDriver();
    }
        else if (currentBrowser.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.chromedriver().browserVersion("146").setup();
            wd = new FirefoxDriver();
        }
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        wd.manage().window().maximize();
        return wd;
        }
        public void launchApp() throws IOException {
            wd=initializeDriver();
            LoginPage loginPage=new LoginPage(wd);
            loginPage.goToURL();
        }
        public String getScreenShot(String testCaseName,WebDriver wd) throws IOException {
            TakesScreenshot ss=(TakesScreenshot) wd;
            File source=ss.getScreenshotAs(OutputType.FILE);
            File dest=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
            FileUtils.copyFile(source,dest);
            return System.getProperty("user.dir")+"//reports//"+testCaseName+".png";
        }

    @AfterClass
    public void tearDown()
    {
        wd.quit();
    }
    }
