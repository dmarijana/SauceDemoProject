package Tests;

import Base.TestBase;
import Pages.HomePage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.ItemNames.Onesie;
import static Base.ItemNames.Redtshirt;

public class ProductTests extends TestBase {
    HomePage homePage;
    ProductPage productPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        productPage = new ProductPage();
        validLogin();
    }

    @Test(priority = 10)
    public void verifyThatProductCanBeAddedAndRemoved() {
        homePage.findElementInList(Onesie).click();
        productPage.clickOnAddToCartButton();
        Assert.assertEquals(homePage.getShoppingCart().getText(), "1");
        productPage.clickOnRemoveFromCartButton();
        Assert.assertTrue(homePage.getShoppingCart().getText().isEmpty());
    }

    @Test(priority = 20)
    public void checkTitleOfProduct() {
        homePage.findElementInList(Redtshirt).click();
        Assert.assertEquals(productPage.getProductName().getText(), Redtshirt);
    }
}