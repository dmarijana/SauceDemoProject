package Pages;

import Base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends TestBase {

    public CartPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cart_item_label")
    List<WebElement> cartItemList;

    @FindBy(id = "continue-shopping")
    WebElement continueShoppingButton;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(className = "inventory_item_price")
    WebElement itemPrice;

    public WebElement getElementInCart(String text) {
        for (WebElement item : cartItemList) {
            if (item.getText().contains(text)) {
                return item;
            }
        }
        return null;
    }

    public String getNameOfElement(WebElement element) {
        return element.getText();
    }

    public void clickButtonOfElement(WebElement element) {
        element.findElement(By.tagName("button")).click();
    }

    public void clickOnCheckoutButton() {
        checkoutButton.click();
    }

    public void clickOnContinueButton() {
        continueShoppingButton.click();
    }

    public Double getItemPrice() {
        return Double.parseDouble(itemPrice.getText().replace("$", ""));
    }
}
