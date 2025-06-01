package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PaymentPage {
    private SHAFT.GUI.WebDriver driver;
    private By nameOnCardInput = By.xpath("//*[@id=\"payment-form\"]/div[1]/div/input");
    private By cardNumberInput = By.xpath("//*[@id=\"payment-form\"]/div[2]/div/input");
    private By cvcInput = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[1]/input");
    private By expiryMonthInput = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[2]/input");
    private By expiryYearInput = By.xpath("//*[@id=\"payment-form\"]/div[3]/div[3]/input");
    private By PayAndConfirm = By.id("submit");
    private By orderSuccessMessage = By.id("success_message");



    public PaymentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void fillPaymentDetails(String nameOnCard, String cardNumber, String cvc, String expiryMonth, String expiryYear){
        driver.element().type(nameOnCardInput, nameOnCard);
        driver.element().type(cardNumberInput, cardNumber);
        driver.element().type(cvcInput, cvc);
        driver.element().type(expiryMonthInput, expiryMonth);
        driver.element().type(expiryYearInput, expiryYear);
    }

    public OrderPlacedPage clickOnPayAndConfirmOrder(){
        driver.element().click(PayAndConfirm);
        return new OrderPlacedPage(driver);
    }

    public void verifyOrderSuccessMessageVisible() throws InterruptedException {
        driver.element().wait(30);
        driver.assertThat().element(orderSuccessMessage).isVisible().withCustomReportMessage("Verify success message is visible").perform();
    }

}
