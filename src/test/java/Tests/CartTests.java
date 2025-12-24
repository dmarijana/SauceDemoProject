package Tests;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
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
        addItemToCart(Onesie);
        homePage.clickOnShoppingCart();
        WebElement cartItem = cartPage.getElementInCart(Onesie);
        String cartItemName = cartPage.getNameOfElement(cartItem);
        Assert.assertTrue(cartItemName.contains(Onesie));
    }

    @Test(priority = 20)
    public void addMultipleItemsToCart() {
        addItemToCart(Onesie);
        addItemToCart(Backpack);
        addItemToCart(BikeLight);
        Assert.assertEquals(homePage.getShoppingCart().getText(), "3");
    }

    @Test(priority = 30)
    public void checkIfElementIsRemovedFromCart() {
        addItemToCart(Backpack);
        homePage.clickOnShoppingCart();
        WebElement cartItem = cartPage.getElementInCart(Backpack);
        cartPage.clickButtonOfElement(cartItem);
        Assert.assertFalse(isElementPresent(cartItem));
    }

    @Test(priority = 40)
    public void continueShoppingAfterCheckingCart() {
        addItemToCart(Backpack);
        homePage.clickOnShoppingCart();
        cartPage.clickOnContinueButton();
        Assert.assertEquals(homePage.getShoppingCart().getText(), "1");
        addItemToCart(Onesie);
        Assert.assertEquals(homePage.getShoppingCart().getText(), "2");
    }
}
