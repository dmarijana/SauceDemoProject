package Tests;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProductPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.ItemNames.*;

public class CartTests extends TestBase {
    HomePage homePage;
    CartPage cartPage;
    ProductPage productPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        cartPage = new CartPage();
        productPage = new ProductPage();
        validLogin();
    }

    @Test(priority = 10)
    public void addOneItemAndCheckCart() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        WebElement cartItem = cartPage.getElementInCart(Onesie);
        String cartItemName = cartPage.getNameOfElement(cartItem);
        Assert.assertTrue(cartItemName.contains(Onesie));
    }

    @Test(priority = 20)
    public void addMultipleItemsToCart() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickButtonOfElementInList(Backpack);
        homePage.clickButtonOfElementInList(BikeLight);
        Assert.assertEquals(homePage.getShoppingCart().getText(), "3");
    }

    @Test(priority = 30)
    public void checkIfElementIsRemovedFromCart() {
        homePage.clickButtonOfElementInList(Backpack);
        homePage.clickOnShoppingCart();
        WebElement cartItem = cartPage.getElementInCart(Backpack);
        cartPage.clickButtonOfElement(cartItem);
        //Ocekujemo da element ne bude prisutan u korpi
        Assert.assertFalse(isElementPresent(cartItem));
    }

    @Test(priority = 40)
    public void continueShoppingAfterCheckingCart() {
        homePage.clickButtonOfElementInList(Backpack);
        homePage.clickOnShoppingCart();
        cartPage.clickOnContinueButton();
        Assert.assertEquals(homePage.getShoppingCart().getText(), "1");
        homePage.clickButtonOfElementInList(Onesie);
        Assert.assertEquals(homePage.getShoppingCart().getText(), "2");
    }
}
