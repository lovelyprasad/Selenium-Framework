package lovelyPrasadOrg.stepDefinition;

import io.cucumber.java.en.Given;
import lovelyPrasadOrg.testComponent.BaseTest;

import java.io.IOException;

public class StepDefinition extends BaseTest {
    @Given(" I landed on Ecommerce page")
    public void  I_landed_on_Ecommerce_page() throws IOException {
        launchApp();
    }

    //you can use tide gerkins
}
