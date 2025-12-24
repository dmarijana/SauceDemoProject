package Tests;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Base.ItemNames.*;

public class CartTests extends TestBase {

    /*@BeforeMethod
    public void pageSetUp() {
        validLogin();
    }*/

    @Test(priority = 10)
    public void addOneItemAndCheckCart() {
        homePage.clickButtonOfElementInList(Onesie);
        homePage.clickOnShoppingCart();
        //Promenljivoj cartItem dodeljujemo vrednost elementa iz korpe
        WebElement cartItem = cartPage.getElementInCart(Onesie);
        //izvlacimo tekst tog elementa i uporedjujemo
        String cartItemText = cartPage.getTextOfElement(cartItem);
        Assert.assertTrue(cartItemText.contains(Onesie));
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
        //Promenljivoj cartItem dodeljujemo vrednost elementa iz korpe
        WebElement cartItem = cartPage.getElementInCart(Backpack);
        //Klikcemo na dugme tog elementa - Remove
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
