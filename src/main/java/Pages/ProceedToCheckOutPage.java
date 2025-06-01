package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProceedToCheckOutPage {
    private SHAFT.GUI.WebDriver driver;
    private By addressDetailsHeader = By.xpath("//*[@id=\"cart_items\"]/div/div[2]/h2");
    private By ReviewYourOrderHeader = By.xpath("//*[@id=\"cart_items\"]/div/div[4]/h2");
    private By comment = By.xpath("//*[@id=\"ordermsg\"]/textarea");
    private By placeOrderBTN = By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");

    private By deliveryAddressLine1 = By.xpath("//*[@id=\"address_delivery\"]/li[4]");
    private By deliveryAddressLine2 = By.xpath("//*[@id=\"address_delivery\"]/li[5]");
    private By billingAddressLine1 = By.xpath("//*[@id=\"address_invoice\"]/li[4]");
    private By billingAddressLine2 = By.xpath("//*[@id=\"address_invoice\"]/li[5]");

    private By deleteBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");



    public ProceedToCheckOutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void  VerifyAddressDetails_ReviewYourOrder(){
        driver.assertThat().element(addressDetailsHeader).isVisible().withCustomReportMessage(" Verify Address Details is displayed").perform();
        driver.assertThat().element(ReviewYourOrderHeader).isVisible().withCustomReportMessage(" Verify Review Your Order is displayed").perform();
    }

    public void scrollToCommentArea_WriteComment(){
        driver.element().scrollToElement(comment);
        driver.element().type(comment, "Test comment area");
    }

    public PaymentPage clickOnPlaceOrder(){
        driver.element().click(placeOrderBTN);
        return new PaymentPage(driver);
    }

    public void VerifyTheDeliveryAddressSameAddressFilledAtRegistration(String expectedDeliveryAddressLine1, String expectedDeliveryAddressLine2) {
        driver.assertThat().element(deliveryAddressLine1).text().isEqualTo(expectedDeliveryAddressLine1)
                .withCustomReportMessage("Verify that the delivery address line 1 matches the registered address.")
                .perform();
        driver.assertThat().element(deliveryAddressLine2).text().isEqualTo(expectedDeliveryAddressLine2)
                .withCustomReportMessage("Verify that the delivery address line 2 matches the registered address.")
                .perform();    }

    public void VerifyBillingAddressSameAddressFilledAtRegistration(String expectedBillingAddressLine1, String expectedBillingAddressLine2) {
        driver.assertThat().element(billingAddressLine1).text().isEqualTo(expectedBillingAddressLine1)
                .withCustomReportMessage("Verify that the billing address line 1 matches the registered address.")
                .perform();

        driver.assertThat().element(billingAddressLine2).text().isEqualTo(expectedBillingAddressLine2)
                .withCustomReportMessage("Verify that the billing address line 2 matches the registered address.")
                .perform();
    }

    public DeletedAccPage clickOnDeleteBTN(){
        driver.element().click(deleteBTN);
        return new DeletedAccPage(driver);
    }

}
