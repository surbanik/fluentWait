package pages;

import basePage.BasePage;
import models.Product;
import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TestPage extends BasePage {

    public TestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "div:nth-child(1)>article>div>a.product-thumbnail")
    WebElement firstProduct;

    @FindBy(css = "[itemprop='price']")
    WebElement price;

    @FindBy(css = ".add-to-cart")
    WebElement addToCartButton;

    @FindBy(css = ".cart-content-btn>.btn-primary")
    WebElement confirmationProceedToCheckout;

    @FindBy(css = "div.checkout .btn-primary")
    WebElement proceedToCheckoutButton;

    @FindBy(css = "[name='address1']")
    WebElement addressInput;

    @FindBy(css = "[name='city']")
    WebElement cityInput;

    @FindBy(css = "[name='postcode']")
    WebElement postcodeInput;

    @FindBy(css = "[name='id_country']")
    WebElement countrySelect;

    @FindBy(css = "input[name='firstname']")
    WebElement firstNameInput;

    @FindBy(css = "input[name='lastname']")
    WebElement lastNameInput;

    @FindBy(css = "input.form-control[name='email']")
    WebElement emailInput;

    @FindBy(css = "[name='password']")
    WebElement passwordInput;

    @FindBy(css = "[name='customer_privacy']")
    WebElement customerPrivacyCheckbox;

    @FindBy(css = "[name='psgdpr']")
    WebElement policyCheckbox;

    @FindBy(css = "[data-link-action='register-new-customer']")
    WebElement saveButton;

    @FindBy(css = ".form-footer .continue")
    WebElement personalInfoContinueButton;

    @FindBy(id = "payment-option-2")
    WebElement payByBankWireInput;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = ".ps-shown-by-js>[type='submit']")
    WebElement placeOrderButton;

    @FindBy(css = "#checkout-delivery-step .continue")
    WebElement deliveryInfoContinueButton;

    @FindBy(css = "#content-hook_order_confirmation .card-title")
    WebElement confirmationMessage;

    @FindBy(css = ".total-value>td:nth-child(2)")
    WebElement totalPrice;


    public TestPage clickOnFirstProduct() {
        performClick(firstProduct);
        return new TestPage(driver);
    }

    public TestPage addProductToCart(Product product) {
        product.setPrice(price.getText());
        performClick(addToCartButton);
        return new TestPage(driver);
    }

    public TestPage clickOnConfirmationProceedToCheckout() {
        performClick(confirmationProceedToCheckout);
        return new TestPage(driver);
    }

    public TestPage clickOnProceedToCheckout() {
        performClick(proceedToCheckoutButton);
        return new TestPage(driver);
    }

    public TestPage registerNewUser(User user){
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setEmail(user.getEmail());
        setPassword(user.getPassword());
        checkCustomerPrivacyCheckbox();
        checkPolicyCheckbox();
        clickOnSaveButton();
        return this;
    }

    public TestPage fillAddressForm(User user) {
        Select country = new Select(countrySelect);

        typeTextTo(addressInput, user.getAddress());
        typeTextTo(cityInput, user.getCity());
        typeTextTo(postcodeInput, user.getZipCode());
        country.selectByVisibleText(user.getCountry());
        return this;

    }

    public TestPage clickOnContinueButtonPersonalInfoSection() {
        performClick(personalInfoContinueButton);
        return this;
    }

    public TestPage clickOnContinueButtonDeliveryInfoSection() {
        performClick(deliveryInfoContinueButton);
        return this;
    }

    public TestPage selectPayByBankWire() {
        performClick(payByBankWireInput);
        return this;
    }

    public TestPage clickOnTermsAndConditionsCheckbox() {
        performClick(termsAndConditionsCheckbox);
        return this;
    }

    public TestPage placeOrder() {
        performClick(placeOrderButton);
        return this;
    }

    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    public String getTotalPrice() {
        return totalPrice.getText();
    }





    public TestPage setFirstName(String name) {
        typeTextTo(firstNameInput,name);
        return this;
    }

    public TestPage setLastName(String lastName) {
        typeTextTo(lastNameInput,lastName);
        return this;
    }

    public TestPage setEmail(String email) {
        typeTextTo(emailInput, email);
        return this;
    }

    public TestPage setPassword(String password) {
        typeTextTo(passwordInput, password);
        return this;
    }

    public TestPage checkCustomerPrivacyCheckbox() {
        performClick(customerPrivacyCheckbox);
        return this;
    }

    public TestPage checkPolicyCheckbox() {
        performClick(policyCheckbox);
        return this;
    }

    public TestPage clickOnSaveButton() {
        performClick(saveButton);
        return new TestPage(driver);
    }








}
