package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ProductDetailPage {

    private SHAFT.GUI.WebDriver driver;
    private By ProductDetails = By.xpath("/html/body/section/div/div/div[2]");
    private By productName = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2");
    private By category = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[1]");
    private By price = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/span");
    private By availability = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[2]");
    private By condition = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[3]");
    private By brand = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/p[4]");
    private By quantityNumber = By.id("quantity");
    private By addCartBTN = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
    private By viewCartBTN = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    private By writeYourReview = By.xpath("/html/body/section/div/div/div[2]/div[3]/div[1]/ul/li/a");

    private By name = By.id("name");
    private By emailAddress = By.id("email");
    private By review = By.id("review");
    private By submitBTN = By.id("button-review");

    private By successMessAfterReview = By.xpath("//*[@id=\"review-section\"]/div/div/span");




    public ProductDetailPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUser_landed_product_detail_page(){
        driver.assertThat().element(ProductDetails).isVisible().withCustomReportMessage("Verify User is landed to product detail page").perform();
    }

    public void verifyDetailsOfProductVisible(){
        driver.assertThat().element(productName).isVisible().withCustomReportMessage("Verify product name is visible").perform();
        driver.assertThat().element(category).isVisible().withCustomReportMessage("Verify category is visible").perform();
        driver.assertThat().element(price).isVisible().withCustomReportMessage("Verify price is visible").perform();
        driver.assertThat().element(availability).isVisible().withCustomReportMessage("Verify availability is visible").perform();
        driver.assertThat().element(condition).isVisible().withCustomReportMessage("Verify condition is visible").perform();
        driver.assertThat().element(brand).isVisible().withCustomReportMessage("Verify brand is visible").perform();
    }

    public void increaseQuantity(int number){
        driver.element().type(quantityNumber,String.valueOf(number));
    }

    public void addToCart(){
        driver.element().click(addCartBTN);
    }

    public CartPage viewCart(){
        driver.element().click(viewCartBTN);
        return new CartPage(driver);
    }

    public void VerifyWriteYourReviewVisible(){
        driver.assertThat().element(writeYourReview).isVisible().withCustomReportMessage("Verify 'Write Your Review' is visible").perform();
    }

    public void writeReview_submit(String Name , String email , String Review ){
        driver.element().type(name,Name);
        driver.element().type(emailAddress, email);
        driver.element().type(review, Review);
        driver.element().click(submitBTN);
    }

    public void VerifySuccessMessageReview(){
        driver.assertThat().element(successMessAfterReview).isVisible().withCustomReportMessage("Verify success message 'Thank you for your review.'").perform();
    }
}
