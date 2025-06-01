package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Signup_loginPage {

    private SHAFT.GUI.WebDriver driver;
    private By NewUserSignupVisible = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2");
    private By nameInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    private By emailAddressInput = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    private By signUpBTN = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");

    private By LoginToYourAccountVisible = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2");
    private By LogInemailAddress = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    private By LogInPass = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    private By LogInBTN = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");


    public Signup_loginPage(SHAFT.GUI.WebDriver driver) {
        this.driver= driver;
    }

    public void verifyNewUserSignupVisible() {
        driver.assertThat().element(NewUserSignupVisible).isVisible().withCustomReportMessage("Verify 'New User Signup!' is visible").perform();
    }

    public Account_info_Page fillSignupDetails(String name, String email) {
        driver.element().type(nameInput, name);
        driver.element().type(emailAddressInput, email);
        driver.element().click(signUpBTN);
        return new Account_info_Page(driver);
    }

    public void verifyLoginToYourAccountVisible() {
        driver.assertThat().element(LoginToYourAccountVisible).isVisible().withCustomReportMessage("Verify 'Login to your account' is visible").perform();
    }

    public LoggedinAccountPage fillLoginDetails(String email, String password) {
        driver.element().type(LogInemailAddress, email);
        driver.element().type(LogInPass, password);
        driver.element().click(LogInBTN);
        return new LoggedinAccountPage(driver);
    }
}
