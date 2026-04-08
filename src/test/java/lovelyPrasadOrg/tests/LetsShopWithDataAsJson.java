package lovelyPrasadOrg.tests;

import lovelyPrasadOrg.data.DataReader;
import lovelyPrasadOrg.pageObjects.*;
import lovelyPrasadOrg.testComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LetsShopWithDataAsJson extends BaseTest {
    public LoginPage loginPage;
    public CheckOutPage checkOutPage;
    public CardDetailsPage cardDetailsPage;
    public ProductCataloguePage productCataloguePage;
    public ConfirmationPage confirmationPage;
    @BeforeMethod
    public void setup() throws IOException {
        launchApp();
        loginPage = new LoginPage(wd);
        checkOutPage = new CheckOutPage(wd);
        cardDetailsPage = new CardDetailsPage(wd);
        productCataloguePage = new ProductCataloguePage(wd);
        confirmationPage = new ConfirmationPage(wd);
    }

    @Test(dataProvider ="getData")
    public void submitOrder(HashMap<String,String> input) throws InterruptedException {

        loginPage.login("lovelyprasad409@gmail.com", "#Ramjeeprasad123");
        productCataloguePage.addProductToCart("ZARA COAT 3");
        productCataloguePage.waitForToastMessageToAppear();
        productCataloguePage.waitForToastMessageToDisappear();
        productCataloguePage.clickCart();
        Assert.assertEquals(productCataloguePage.getNoOfProductsInCart(), 1);
        checkOutPage.clickCheckout();
        cardDetailsPage.enterCvv("032");
        cardDetailsPage.enterNameOnCard("Lovely");
        cardDetailsPage.enterAndSelectCountry("India");
        cardDetailsPage.clickSubmit();
        Assert.assertEquals(confirmationPage.getConfirmationMessage(), "THANKYOU FOR THE ORDER.");
    }
    /**
     * data as hashmap object
     */
    @DataProvider
    public Object[][] getData() throws IOException {
        DataReader dr=new DataReader();
        List<HashMap<String, String>> d=dr.getDataToMap();
        return new Object[][] {{d},{d}};
    }
}