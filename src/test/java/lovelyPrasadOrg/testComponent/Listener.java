package lovelyPrasadOrg.testComponent;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import lombok.SneakyThrows;
import lovelyPrasadOrg.resources.ExtentReportNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

import java.io.IOException;


public class Listener extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent=ExtentReportNG.getReportObject();
    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Success");


    }

    @Override
    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL,"Fail");
        //Gives the error message
        test.fail(result.getThrowable());
        try {
            wd=(WebDriver) result.getTestClass().getRealClass().getField("wd").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        String filePath= null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(),wd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filePath, result.getMethod().getMethodName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
