import Pages.*;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AllProducts_TestCases {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private AllProductsPage allProductsPageObj;
    private ProductDetailPage productDetailPageObj;
    private CartPage cartPageObj;
    private Signup_loginPage signup_loginPageObj;
    private LoggedinAccountPage loggedinAccountPageObj ;

    private String productName = "Sleeveless Dress";
    private String CorrectEmail = "suzo@mailinator.com";
    private String CorrectPassword = "12345";

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
    public void TestCase8_Verify_AllProducts_product_detail_page(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        allProductsPageObj = homePageObj.clickProductsBTN();
        allProductsPageObj.Verify_user_navigated_ALL_PRODUCTS_page_successfully();
        allProductsPageObj.verifyProductsListVisible();

        productDetailPageObj = allProductsPageObj.clickViewProductOfFirstProduct();
        productDetailPageObj.verifyUser_landed_product_detail_page();
        productDetailPageObj.verifyDetailsOfProductVisible();

    }

    @Test
    public void TestCase9_SearchProduct(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        allProductsPageObj = homePageObj.clickProductsBTN();
        allProductsPageObj.Verify_user_navigated_ALL_PRODUCTS_page_successfully();
        allProductsPageObj.SearchProduct(productName);
        allProductsPageObj.VerifySearchedProductVisible();
        allProductsPageObj.verifyAllSearchedProductsVisible();
    }

    @Test
    public void TestCase20_SearchProductsVerifyCartAfterLogin(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        allProductsPageObj = homePageObj.clickProductsBTN();
        allProductsPageObj.Verify_user_navigated_ALL_PRODUCTS_page_successfully();
        allProductsPageObj.SearchProduct(productName);
        allProductsPageObj.VerifySearchedProductVisible();
        allProductsPageObj.verifyAllSearchedProductsVisible();
        allProductsPageObj.addSearchedProduct();

        cartPageObj = homePageObj.clickCartBTN();
        cartPageObj.VerifyCartPageDisplayed();

        signup_loginPageObj = homePageObj.clickSignupLoginButton();

        loggedinAccountPageObj = signup_loginPageObj.fillLoginDetails(CorrectEmail,CorrectPassword);
        loggedinAccountPageObj.clickOnCartBTN();

        cartPageObj.VerifyCartPageDisplayed();
    }


}
