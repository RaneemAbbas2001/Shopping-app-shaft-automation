import Pages.*;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTestCases {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private Signup_loginPage Signup_loginPageObj;
    private CreatedAccountPage createdAccountPageObj;
    private LoggedinAccountPage loggedinAccountPageObj;
    private Account_info_Page Account_info_Obj;
    private DeletedAccPage deleteAccObj;

    // Test Data
    private String name = "Test User";
    private String email = "testuser" + System.currentTimeMillis() + "@example.com"; // Unique email
    private String password = "password123";
    private String day = "1";
    private String month = "January";
    private String year = "2000";
    private String firstName = "Test";
    private String lastName = "User";
    private String company = "Test Company";
    private String address = "123 Test Address";
    private String address2 = "Apt 4B";
    private String country = "Canada";
    private String state = "Ontario";
    private String city = "Toronto";
    private String zipcode = "M5V 2H1";
    private String mobileNumber = "1234567890";

    private String ExistName = "r";
    private String ExistEmail = "r@rr.com";
    private By EmailAddressAlreadyExistError = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");

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
    public void TestCase1_RegisterUser(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        Signup_loginPageObj = homePageObj.clickSignupLoginButton();
        Signup_loginPageObj.verifyNewUserSignupVisible();

        Account_info_Obj = Signup_loginPageObj.fillSignupDetails(name,email);
        Account_info_Obj.verifyEnterAccountInfoVisible();
        Account_info_Obj.fillAccountDetails(password,day,month,year);
        Account_info_Obj.selectNewsLetterAndOffers();
        Account_info_Obj.fillAddressDetails(firstName,lastName,company,address,address2,country,state,city,zipcode,mobileNumber);

        createdAccountPageObj = Account_info_Obj.clickCreateAccountButton();
        createdAccountPageObj.verifyAccountCreatedVisible();

        loggedinAccountPageObj = createdAccountPageObj.clickContinueButton();
        loggedinAccountPageObj.verifyLoggedInAsVisible(name);

        deleteAccObj = loggedinAccountPageObj.clickDeleteAccountButton();
        deleteAccObj.verifyAccountDeletedVisible();
        homePageObj = deleteAccObj.clickContinueButton();
    }

    @Test
    public void TestCase5_Register_User_with_existing_email(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        Signup_loginPageObj = homePageObj.clickSignupLoginButton();
        Signup_loginPageObj.verifyNewUserSignupVisible();

        Account_info_Obj = Signup_loginPageObj.fillSignupDetails(ExistName,ExistEmail);
        driver.assertThat().element(EmailAddressAlreadyExistError).isVisible().withCustomReportMessage("Verify error 'Email Address already exist!' is visible").perform();

    }
}
