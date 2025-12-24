package Tests;

import Base.TestBase;
import Pages.CartPage;
import Pages.CheckoutPage;
import Pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Base.ItemNames.Onesie;

public class CheckoutTests extends TestBase {
    HomePage homePage;
    CartPage cartPage;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void pageSetUp() {
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        validLogin();
    }

    @Test(priority = 10)
    public void verifyProductCanBeOrdered() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        Double priceInCart = cartPage.getItemPrice();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Marijana");
        checkoutPage.inputLastName("Dilparic");
        checkoutPage.inputPostalCode("34000");
        checkoutPage.clickOnContinueButton();
        Double priceInCheckout = checkoutPage.getItemPrice();
        Assert.assertEquals(priceInCart, priceInCheckout);
        checkoutPage.clickOnFinishButton();
        Assert.assertTrue(isElementPresent(checkoutPage.getSuccessMessage()));
        checkoutPage.clickOnBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 20)
    public void verifyCustomerInfoCantBeEmpty() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(isElementPresent(checkoutPage.getErrorMessage()));
        checkoutPage.inputFirstName("Marijana");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(isElementPresent(checkoutPage.getErrorMessage()));
        checkoutPage.inputLastName("Dilparic");
        checkoutPage.clickOnContinueButton();
        Assert.assertTrue(isElementPresent(checkoutPage.getErrorMessage()));
        checkoutPage.inputPostalCode("34000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnFinishButton();
        Assert.assertTrue(isElementPresent(checkoutPage.getSuccessMessage()));
        checkoutPage.clickOnBackHomeButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test(priority = 30)
    public void verifyOrderCanBeCanceled() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Marijana");
        checkoutPage.inputLastName("Dilparic");
        checkoutPage.inputPostalCode("34000");
        checkoutPage.clickOnContinueButton();
        checkoutPage.clickOnCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
