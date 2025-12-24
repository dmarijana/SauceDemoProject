package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class HomePage extends TestBase {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "react-burger-menu-btn")
    private WebElement menuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement sideLogoutButton;

    @FindBy(css = ".inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCart;

    @FindBy(className = "product_sort_container")
    private WebElement filterButton;

    @FindBy(css = "option[value='lohi']")
    private WebElement lowToHighOption;

    @FindBy(css = "option[value='az']")
    private WebElement atoZOption;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryItemNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryItemPrices;

    public void clickOnSideLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(sideLogoutButton));
        sideLogoutButton.click();
    }

    public void clickOnMenuButton() {
        menuButton.click();
    }

    public void clickOnLowToHighOption() {
        lowToHighOption.click();
    }

    public void clickOnAtoZOption() {
        atoZOption.click();
    }

    public void clickOnShoppingCart() {
        shoppingCart.click();
    }

    public void clickOnFilterButton() {
        filterButton.click();
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public List<WebElement> getInventoryItemNames() {
        return inventoryItemNames;
    }

    public List<WebElement> getInventoryItemPrices() {
        return inventoryItemPrices;
    }

    //Metoda koja klince na dugme elementa po nazivu elementa (moze biti add to cart ili remove)
    public void clickButtonOfElementInList(String productName) {
        for (WebElement item : inventoryItems) {

            String name = item.findElement(By.className("inventory_item_name")).getText();

            if (name.equals(productName)) {
                item.findElement(By.tagName("button")).click();
                break;
            }
        }
    }

    //Metoda koja vraca element (proizvod) u listi po tekstu
    public WebElement findElementInList(String text) {
        for (WebElement item : inventoryItems) {
            if (item.getText().contains(text)) {
                return item;
            }
        }
        return null;
    }
}