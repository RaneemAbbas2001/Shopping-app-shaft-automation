import Pages.HomePage;
import Pages.ProductDetailPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage_TestCases {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private ProductDetailPage productDetailPageObj;


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
    public void TestCase10_VerifySubscription_home_page() {
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();
        homePageObj.scrollDownFooter();
        homePageObj.Verify_text_SUBSCRIPTION();
        homePageObj.enter_SUBSCRIPTION("tst@tst.com");
        homePageObj.Verify_success_message_YouHaveBeenSuccessfullySubscribed();
    }

    @Test
    public void TestCase22_AddCartFromRecommendedItems(){
        homePageObj.navigateToHomePage();
        homePageObj.scrollDownToRecommendedItems();
        homePageObj.VerifyRECOMMENDED_ITEMSVisible();
        homePageObj.addRecommendProduct();

        productDetailPageObj = homePageObj.clickViewProductBTN();
        productDetailPageObj.verifyDetailsOfProductVisible();
    }

    @Test
    public void TestCase25_VerifyScrollUpUsingArrowButtonScrollDownFunctionality(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();
        homePageObj.scrollDownFooter();
        homePageObj.Verify_text_SUBSCRIPTION();
        homePageObj.clickOnMoveUpwardBTN();
        homePageObj.VerifyFullFledgedAutomationEngineersTextVisibleOnScreen();
    }

    @Test
    public void TestCase26_VerifyScrollUpWithoutArrowButtonScrollDownFunctionality(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();
        homePageObj.scrollDownFooter();
        homePageObj.Verify_text_SUBSCRIPTION();
        homePageObj.scrollUpToHeader();
        homePageObj.VerifyFullFledgedAutomationEngineersTextVisibleOnScreen();
    }

}
