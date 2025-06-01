import Pages.ContactUsPage;
import Pages.HomePage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class ContactUsTestCases {
    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private ContactUsPage contactUsObj;

    private String name = "Ahmed";
    private String email = "ahmed@test.com";
    private String subject = "Need test";
    private String message = "Test contact us form ";
    private String filePath = Paths.get("C:\\Users\\ranee\\IdeaProjects\\SHAFT-Task\\src\\test\\resources\\testDataFiles\\test.docx").toString();


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
    public void TestCase6_ContactUsForm(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        contactUsObj = homePageObj.clickContactUsBTN();
        contactUsObj.Verify_GET_IN_TOUCH_Visible();
        contactUsObj.fillContactForm(name,email,subject,message);
        contactUsObj.uploadFile(filePath);
        contactUsObj.clickSubmitButton();
        contactUsObj.AcceptSuccessAlert();
        contactUsObj.verifySuccessMessageVisible();

        homePageObj = contactUsObj.ReturnHome();
    }

}
