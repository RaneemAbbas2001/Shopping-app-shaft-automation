import Pages.Category_BrandPage;
import Pages.HomePage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CategoryTestCases {
    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private Category_BrandPage category_brandPageObj;

    private String expectedText = "WOMEN - DRESS PRODUCTS";
    private String expectedText2 = "MEN - TSHIRTS PRODUCTS";
    private String expectedText3 = "BRAND - H&M PRODUCTS";


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
    public void TestCase18_ViewCategoryProducts(){
        homePageObj.navigateToHomePage();
        homePageObj.scrollToCategoryLeftSideBar();
        homePageObj.VerifyCategoriesVisibleLeftSidebar();
        homePageObj.clickOnWomenBTN();

        category_brandPageObj = homePageObj.clickOnSubWomenBTN();
        category_brandPageObj.verifyCategoryPageVisible(expectedText);
        category_brandPageObj.clickOnMenBTN();
        category_brandPageObj.clickOnSubMentBTN();
        category_brandPageObj.verifyCategoryPage(expectedText2);
    }

    @Test
    public void TestCase19_ViewCartBrandProducts(){
        homePageObj.navigateToHomePage();
        homePageObj.clickProductsBTN();
        homePageObj.scrollToCategoryLeftSideBar();
        homePageObj.VerifyBrandVisibleLeftSidebar();

        category_brandPageObj = homePageObj.clickBrandBTN();
        category_brandPageObj.verifyBrandPage(expectedText3);

    }
}
