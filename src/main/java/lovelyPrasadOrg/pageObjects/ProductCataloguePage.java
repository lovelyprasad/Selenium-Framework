package lovelyPrasadOrg.pageObjects;

import lovelyPrasadOrg.abstractComponents.WaitPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCataloguePage extends WaitPage {
        WebDriver wd;
        public ProductCataloguePage(WebDriver wd)
        {
            super(wd);
            this.wd=wd;
            PageFactory.initElements(wd,this);
        }
        @FindBy(css=".mb-3")
        List<WebElement> products;
        By productList=By.cssSelector(".mb-3");
        @FindBy(css="[routerlink$='cart']")
        WebElement cart_button;

        public List<WebElement> getProductList()
        {
            waitForElementToAppear(productList);
            return products;
        }
        private WebElement getProductByName(String productName)
        {
            WebElement prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
            return prod;
        }
        public void addProductToCart(String productName)
        {
            WebElement prod=getProductByName(productName);
            prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();

        }
        public void waitForToastMessageToAppear()
        {
            waitForElementToAppear(By.cssSelector("#toast-container"));

        }
        public void waitForToastMessageToDisappear()
        {
            waitForElementToDisappear(By.cssSelector("#toast-container"));
        }
        public void clickCart() throws InterruptedException {
            Thread.sleep(1000);
            cart_button.click();
        }
        @FindBy(css=".items .infoWrap")
        List <WebElement> listOfProductsInCart;
        int noOfProductsInCart;
        public int getNoOfProductsInCart()
        {
            return listOfProductsInCart.size();
        }
}