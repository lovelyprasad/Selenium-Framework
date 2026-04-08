package lovelyPrasadOrg.testComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailed implements IRetryAnalyzer {
    int count=0;
    int maxTry=2;
    @Override
    public boolean retry(ITestResult result) {
        if(count<maxTry)
        {
            return true;
        }
        return false;
    }
}
