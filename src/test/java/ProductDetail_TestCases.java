import Pages.AllProductsPage;
import Pages.HomePage;
import Pages.ProductDetailPage;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductDetail_TestCases {

    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private AllProductsPage allProductsPageObj;
    private ProductDetailPage productDetailPageObj;

    private String name = "Zoro";
    private String emailAddress = "zoro@tst.com";
    private String review = "Nice product";

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
    public void TestCase21_AddReviewOnProduct(){
        homePageObj.navigateToHomePage();

        allProductsPageObj = homePageObj.clickProductsBTN();
        allProductsPageObj.Verify_user_navigated_ALL_PRODUCTS_page_successfully();

        productDetailPageObj = allProductsPageObj.clickViewProductOfFirstProduct();
        productDetailPageObj.VerifyWriteYourReviewVisible();
        productDetailPageObj.writeReview_submit(name,emailAddress,review);
        productDetailPageObj.VerifySuccessMessageReview();
    }
}
