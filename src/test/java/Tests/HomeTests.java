package Tests;

import Base.TestBase;
import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Base.ItemNames.Jacket;

public class HomeTests extends TestBase {
    LoginPage loginPage;
    LoginTests loginTests;
    HomePage homePage;
    CartPage cartPage;

    @BeforeMethod
    public void pageSetUp() {
        loginPage = new LoginPage();
        loginTests = new LoginTests();
        homePage = new HomePage();
        cartPage = new CartPage();
        validLogin();
    }

    @Test(priority = 10)
    public void verifyUserCanLogout() {
        homePage.clickOnMenuButton();
        homePage.clickOnSideLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
    }

    @Test(priority = 20)
    public void verifyProductCanBeAddedAndRemovedFromCart() {
        homePage.clickButtonOfElementInList(Jacket);
        Assert.assertEquals(homePage.getShoppingCart().getText(), "1");
        homePage.clickButtonOfElementInList(Jacket);
        Assert.assertTrue(homePage.getShoppingCart().getText().isEmpty());
    }

    @Test(priority = 30)
    public void sortItemsByPriceAscending() {
        homePage.clickOnFilterButton();
        homePage.clickOnLowToHighOption();
        List<Double> actualPrices = new ArrayList<>();

        for(WebElement price : homePage.getInventoryItemPrices()) {
            actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);
        Assert.assertEquals(actualPrices, expectedPrices);
    }

    @Test(priority = 40)
    public void sortItemsByNameAToZ() {
        homePage.clickOnFilterButton();
        homePage.clickOnAtoZOption();
        List<String> actualNames = new ArrayList<>();

        for(WebElement name : homePage.getInventoryItemNames()) {
            actualNames.add(name.getText());
        }

        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);
    }
}
