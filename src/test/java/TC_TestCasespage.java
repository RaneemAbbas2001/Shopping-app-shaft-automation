import Pages.HomePage;
import Pages.TestCasesPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_TestCasespage {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private TestCasesPage testCasesObj;

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
    public void TestCase7_Verify_Test_Cases_Page(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        testCasesObj = homePageObj.clickTestCasesBTN();
        testCasesObj.Verify_user_navigated_to_testCases_page_successfully();
    }
}
