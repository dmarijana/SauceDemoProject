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

    @Test(priority = 10)
    public void verifyProductCanBeOrdered() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        //Prikupljamo cenu kako bismo je uporedili sa cenom na racunu
        String priceInCart = cartPage.getItemPrice();
        cartPage.clickOnCheckoutButton();
        checkoutPage.inputFirstName("Marijana");
        checkoutPage.inputLastName("Dilparic");
        checkoutPage.inputPostalCode("34000");
        checkoutPage.clickOnContinueButton();
        //Prikupljamo cenu na racunu da bismo je asertovali
        String priceInCheckout = checkoutPage.getItemPrice();
        //Assert cene iz cart-a i cene na zavrsnom racunu
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
        //Ocekujemo da error poruka bude prisutna jer nismo popunili nista
        Assert.assertTrue(isElementPresent(checkoutPage.getErrorMessage()));
        checkoutPage.inputFirstName("Marijana");
        checkoutPage.clickOnContinueButton();
        //Ocekujemo da error poruka bude prisutna jer smo popunili samo ime
        Assert.assertTrue(isElementPresent(checkoutPage.getErrorMessage()));
        checkoutPage.inputLastName("Dilparic");
        checkoutPage.clickOnContinueButton();
        //Ocekujemo da error poruka bude prisutna jer smo popunili samo ime i prezime
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
