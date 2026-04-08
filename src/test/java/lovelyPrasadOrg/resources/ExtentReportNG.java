package lovelyPrasadOrg.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {
    public static ExtentReports getReportObject()
    {
        String path=System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        reporter.config().setReportName("Suite 1");
        reporter.config().setDocumentTitle("Suite 1 Test Results");
        ExtentReports extent =new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }

}
