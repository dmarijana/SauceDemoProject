package Tests;

import Base.TestBase;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    LoginPage loginPage;

    @BeforeMethod
    public void pageSetUp() {
        loginPage = new LoginPage();
    }

    @Test(priority = 10)
    public void userCantLoginWithInvalidUsername() {
        loginPage.inputUsername("invalidUser");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(isElementPresent(loginPage.getErrorMessage()));
    }

    @Test(priority = 20)
    public void userCantLoginWithInvalidPassword() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("invalidPassword");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(isElementPresent(loginPage.getErrorMessage()));
    }
}