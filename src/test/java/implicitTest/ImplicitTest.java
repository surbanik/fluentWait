package implicitTest;

import models.Product;
import models.User;
import models.UserFactory;
import org.junit.jupiter.api.RepeatedTest;
import pages.TestPage;
import testBase.TestBase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ImplicitTest extends TestBase {

    @RepeatedTest(30)
    public void implilcitTest() {
        User user = new UserFactory().getRandomUser();
        TestPage testPage = new TestPage(driver);
        Product product = new Product();

        testPage.clickOnFirstProduct()
                .addProductToCart(product)
                .clickOnConfirmationProceedToCheckout()
                .clickOnProceedToCheckout()
                .registerNewUser(user)
                .fillAddressForm(user)
                .clickOnContinueButtonPersonalInfoSection()
                .clickOnContinueButtonDeliveryInfoSection()
                .selectPayByBankWire()
                .clickOnTermsAndConditionsCheckbox()
                .placeOrder();

        assertTrue(testPage.getConfirmationMessage().contains("YOUR ORDER IS CONFIRMED"));
        assertEquals(testPage.getTotalPrice(), product.getPrice());
    }
}
