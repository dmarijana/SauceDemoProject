package Base;

import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public LoginPage loginPage;
    public HomePage homePage;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://saucedemo.com/");
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    public void validLogin() {
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    //Metoda koja proverava da li je element prisutan, kao argument prima web element
    public boolean isElementPresent(WebElement element) {
        boolean isPresent = false;

        try {
            isPresent = element.isDisplayed();
        } catch (Exception e) {
            System.out.println("Element is not present or visible");
        }

        return isPresent;
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
