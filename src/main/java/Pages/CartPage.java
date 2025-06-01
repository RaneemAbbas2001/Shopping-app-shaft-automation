package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CartPage {
    private SHAFT.GUI.WebDriver driver;
    private By descriptionFooter = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private By descriptionEmail = By.id("susbscribe_email");
    private By descriptionEmailArrow = By.id("subscribe");
    private By successSubscriptionAlert = By.xpath("//*[@id=\"success-subscribe\"]/div");

    private By item1 = By.id("product-1");
    private By item2 = By.id("product-2");

    private By item1Price = By.xpath("//*[@id=\"product-1\"]/td[3]");
    private By item1Quantity = By.xpath("//*[@id=\"product-1\"]/td[4]");
    private By item1TotalPrice = By.xpath("//*[@id=\"product-1\"]/td[5]");

    private By item2Price = By.xpath("//*[@id=\"product-2\"]/td[3]");
    private By item2Quantity = By.xpath("//*[@id=\"product-2\"]/td[4]");
    private By item2TotalPrice = By.xpath("//*[@id=\"product-2\"]/td[5]");

    private By productQuantity = By.xpath("//*[@id=\"product-2\"]/td[4]/button");
    private By cartInfo = By.xpath("//*[@id=\"cart_info_table\"]");
    private By proceedToCheckOutBTN = By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a");
    private By Register_LoginBTN = By.xpath("//*[@id=\"checkoutModal\"]/div/div/div[2]/p[2]/a/u");

    private By removeProductBTN = By.xpath("//*[@id=\"product-1\"]/td[6]/a");
    private By emptyCartMessage = By.id("empty_cart");


    public CartPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void scrollDownFooter(){
        driver.element().scrollToElement(descriptionFooter);
    }

    public void Verify_text_SUBSCRIPTION() {
        driver.assertThat().element(descriptionFooter).text().isEqualTo("SUBSCRIPTION").withCustomReportMessage("Verify 'SUBSCRIPTION' text in footer").perform();
    }

    public void enter_SUBSCRIPTION(String desciptEmail ){
        driver.element().type(descriptionEmail,desciptEmail);
        driver.element().click(descriptionEmailArrow);
    }

    public void Verify_success_message_YouHaveBeenSuccessfullySubscribed() {
        driver.assertThat().element(successSubscriptionAlert).isVisible().withCustomReportMessage("Verify success message is visible").perform();
    }

    public void  Verify_both_products_added_Cart(){
        driver.assertThat().element(item1).isVisible().withCustomReportMessage("Verify product 1 is added to cart").perform();
        driver.assertThat().element(item2).isVisible().withCustomReportMessage("Verify product 2 is added to cart").perform();
    }

    public void  VerifyProducts_prices_quantity_totalPrice(){
        driver.assertThat().element(item1Price).isVisible().withCustomReportMessage("Verify product 1 price").perform();
        driver.assertThat().element(item1Quantity).isVisible().withCustomReportMessage("Verify product 1 quantity").perform();
        driver.assertThat().element(item1TotalPrice).isVisible().withCustomReportMessage("Verify product 1 total price").perform();

        driver.assertThat().element(item2Price).isVisible().withCustomReportMessage("Verify product 2 price").perform();
        driver.assertThat().element(item2Quantity).isVisible().withCustomReportMessage("Verify product 2 quantity").perform();
        driver.assertThat().element(item2TotalPrice).isVisible().withCustomReportMessage("Verify product 2 total price").perform();

    }

    public void verifyProductQuantityInCart(int expectedQuantity) {
        driver.assertThat().element(productQuantity).text().isEqualTo(String.valueOf(expectedQuantity))
                .withCustomReportMessage("Verify quantity of product in cart ").perform();
    }

    public void VerifyCartPageDisplayed(){
        driver.assertThat().element(cartInfo).isVisible().withCustomReportMessage("Verify that cart page is displayed").perform();
    }

    public ProceedToCheckOutPage clickOnProceedBTN(){
        driver.element().click(proceedToCheckOutBTN);
        return new ProceedToCheckOutPage(driver);
    }

    public Signup_loginPage clickOnRegister_LoginBTN(){
        driver.element().click(Register_LoginBTN);
        return new Signup_loginPage(driver);
    }

    public void clickOnRemoveBTN(){
        driver.element().click(removeProductBTN);
    }

    public void verifyThatProductRemoved(){
        driver.assertThat().element(emptyCartMessage).isVisible().withCustomReportMessage("Verify that product is removed from the cart").perform();
    }


}
