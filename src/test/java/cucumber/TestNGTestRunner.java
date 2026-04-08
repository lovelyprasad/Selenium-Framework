package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features ="src/test/java/cucumber",glue ="lovelyPrasadOrg.stepDefinition.StepDefinition",monochrome = true,plugin = {"html:cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

}
