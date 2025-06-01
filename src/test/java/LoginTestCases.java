import Pages.*;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestCases {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private Signup_loginPage Signup_loginPageObj;
    private LoggedinAccountPage loggedinAccountPageObj;
    private DeletedAccPage deleteAccObj;

    private String name = "x";
    private String CorrectEmail = "x@xtest.com";
    private String CorrectPassword = "123";

    private String incorrectEmail = "invalid@example.com";
    private String incorrectPassword = "wrongpassword";
    private By LoginErrorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p");

    private String LogInEmail = "User@User.com";
    private String LogInPassword = "12345";
    private String LogInName = "User";


    @BeforeMethod
    public void setup() {
        driver = new SHAFT.GUI.WebDriver();
        homePageObj = new HomePage(driver);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.browser().closeCurrentWindow();
        }
    }

    @Test
    public void TestCase2_Login_User_with_correct_email_password(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        Signup_loginPageObj = homePageObj.clickSignupLoginButton();
        Signup_loginPageObj.verifyLoginToYourAccountVisible();

        loggedinAccountPageObj = Signup_loginPageObj.fillLoginDetails(CorrectEmail,CorrectPassword);
        loggedinAccountPageObj.verifyLoggedInAsVisible(name);

        deleteAccObj = loggedinAccountPageObj.clickDeleteAccountButton();
        deleteAccObj.verifyAccountDeletedVisible();
    }

    @Test
    public void TestCase3_Login_User_with_incorrect_email_password(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        Signup_loginPageObj = homePageObj.clickSignupLoginButton();
        Signup_loginPageObj.verifyLoginToYourAccountVisible();

        loggedinAccountPageObj = Signup_loginPageObj.fillLoginDetails(incorrectEmail,incorrectPassword);
        driver.assertThat().element(LoginErrorMessage).isVisible().withCustomReportMessage("Verify error 'Your email or password is incorrect!' is visible").perform();

    }

    @Test
    public void TestCase4_LogoutUser(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        Signup_loginPageObj = homePageObj.clickSignupLoginButton();
        Signup_loginPageObj.verifyLoginToYourAccountVisible();

        loggedinAccountPageObj = Signup_loginPageObj.fillLoginDetails(LogInEmail,LogInPassword);
        loggedinAccountPageObj.verifyLoggedInAsVisible(LogInName);

        Signup_loginPageObj = loggedinAccountPageObj.Logout();
        Signup_loginPageObj.verifyLoginToYourAccountVisible();
        Signup_loginPageObj.verifyNewUserSignupVisible();

    }
}
