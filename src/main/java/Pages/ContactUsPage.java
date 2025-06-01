package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ContactUsPage {

    private SHAFT.GUI.WebDriver driver;
    private By getInTouchVisible = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2");
    private By nameField = By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    private By emailField = By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input");
    private By subjectField = By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input");
    private By messageField = By.id("message");
    private By uploadFileButton = By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input");
    private By submitButton = By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input");
    private By successAlert = By.xpath("//div[@class='alert alert-success']");
    private By succesMessage = By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]");
    private By HomeBTN = By.xpath("//*[@id=\"form-section\"]/a/span");



    public ContactUsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void Verify_GET_IN_TOUCH_Visible(){
        driver.assertThat().element(getInTouchVisible).isVisible().withCustomReportMessage("Verify 'GET IN TOUCH' is visible").perform();
    }

    public void fillContactForm(String name, String email, String subject, String message){
        driver.element().type(nameField,name);
        driver.element().type(emailField,email);
        driver.element().type(subjectField,subject);
        driver.element().type(messageField,message);
    }

    public void uploadFile(String filePath) {
        driver.element().typeFileLocationForUpload(uploadFileButton, filePath);
    }

    public void clickSubmitButton() {
        driver.element().click(submitButton);
    }

    public void AcceptSuccessAlert() {
        driver.alert().acceptAlert();
    }

    public void verifySuccessMessageVisible() {
        driver.assertThat().element(succesMessage).isVisible().withCustomReportMessage("Verify success message is visible").perform();
    }

    public HomePage ReturnHome(){
        driver.element().click(HomeBTN);
        return new HomePage(driver);
    }

}
