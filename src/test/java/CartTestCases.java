import Pages.AllProductsPage;
import Pages.CartPage;
import Pages.HomePage;
import Pages.ProductDetailPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTestCases {
    private SHAFT.GUI.WebDriver driver;
    private HomePage homePageObj;
    private CartPage cartPageObj;
    private AllProductsPage allProductsPageObj;
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
    public void TestCase11_Verify_Subscription_CartPage(){
            homePageObj.navigateToHomePage();
            homePageObj.verifyHomePageVisible();

            cartPageObj = homePageObj.clickCartBTN();
            cartPageObj.scrollDownFooter();
            cartPageObj.Verify_text_SUBSCRIPTION();
            cartPageObj.enter_SUBSCRIPTION("test@test.com");
            cartPageObj.Verify_success_message_YouHaveBeenSuccessfullySubscribed();
    }

    @Test
    public void TestCase12_AddProductInCarts(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();

        allProductsPageObj = homePageObj.clickProductsBTN();
        allProductsPageObj.hoverOverProducts();

        cartPageObj = allProductsPageObj.clickViewCartBTN();
        cartPageObj.Verify_both_products_added_Cart();
        cartPageObj.VerifyProducts_prices_quantity_totalPrice();
    }

    @Test
    public void TestCase13_VerifyProductQuantityInCart(){
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();
        homePageObj.scrollDownToFeature();

        productDetailPageObj = homePageObj.clickViewProductBTN();
        productDetailPageObj.verifyUser_landed_product_detail_page();
        productDetailPageObj.increaseQuantity(4);
        productDetailPageObj.addToCart();

        cartPageObj = productDetailPageObj.viewCart();
        cartPageObj.verifyProductQuantityInCart(4);
    }

    @Test
    public void TestCase17_RemoveProductsFromCart() throws InterruptedException {
        homePageObj.navigateToHomePage();
        homePageObj.verifyHomePageVisible();
        homePageObj.addProducts();

        cartPageObj = homePageObj.clickCartBTN();
        cartPageObj.VerifyCartPageDisplayed();
        cartPageObj.clickOnRemoveBTN();
        cartPageObj.clickOnRemoveBTN();
        cartPageObj.clickOnRemoveBTN();
        cartPageObj.verifyThatProductRemoved();

    }

}
