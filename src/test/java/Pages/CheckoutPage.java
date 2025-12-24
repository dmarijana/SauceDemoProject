package Pages;

import Base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends TestBase {

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameField;

    @FindBy(id = "last-name")
    private WebElement lastNameField;

    @FindBy(id = "postal-code")
    private WebElement postalCodeField;

    @FindBy(css = "h3[data-test='error']")
    private WebElement errorMessage;

    @FindBy(id = "continue")
    private WebElement continueButton;

    @FindBy(className = "inventory_item_price")
    private WebElement itemPrice;

    @FindBy(id = "finish")
    private WebElement finishButton;

    @FindBy(id = "cancel")
    private WebElement cancelButton;

    @FindBy(id = "checkout_complete_container")
    private WebElement successMessage;

    @FindBy(id = "back-to-products")
    private WebElement backHomeButton;


    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        postalCodeField.clear();
        postalCodeField.sendKeys(postalCode);
    }

    public void clickOnContinueButton() {
        continueButton.click();
    }

    //Prikuplja cenu proizvoda u korpi
    public String getItemPrice() {
        return itemPrice.getText();
    }

    public void clickOnFinishButton() {
        finishButton.click();
    }

    public void clickOnCancelButton() {
        cancelButton.click();
    }

    public void clickOnBackHomeButton() {
        backHomeButton.click();
    }

    public WebElement getSuccessMessage() {
        return successMessage;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
