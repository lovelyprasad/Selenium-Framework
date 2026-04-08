package lovelyPrasadOrg.tests;

import lovelyPrasadOrg.pageObjects.*;
import lovelyPrasadOrg.testComponent.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class LetsShopWithArrayDataProviderTest extends BaseTest {
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

    @Test(dataProvider = "getData")
    public void submitOrder(String email,String pass,String product) throws InterruptedException {

        loginPage.login(email,pass);
        productCataloguePage.addProductToCart(product);
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
     * data as array object
     */
    @DataProvider
        public Object[][] getData()
        {
            return new Object[][] {{"lovelyprasad409@gmail.com","#Ramjeeprasad123","ZARA COAT 3"},{"xyz@gmail.com","gugh","addidas shoe"}};
        }

}
