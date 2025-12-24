package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends TestBase {

    public ProductPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_details_name.large_size")
    private WebElement productName;

    @FindBy(id = "add-to-cart")
    private WebElement addToCartButton;

    @FindBy(id = "remove")
    private WebElement removeFromCartButton;

    public void clickOnAddToCartButton() {
        addToCartButton.click();
    }

    public void clickOnRemoveFromCartButton() {
        removeFromCartButton.click();
    }

    public WebElement getProductName() {
        return productName;
    }
}
