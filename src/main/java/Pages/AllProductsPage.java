package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AllProductsPage {

    private SHAFT.GUI.WebDriver driver;
    private By allProductsHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By allProductsList = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    private By ViewProductBTN = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    private By SearchBar = By.id("search_product");
    private By SearchIcon = By.id("submit_search");
    private By SearchedProductVisible = By.xpath("/html/body/section[2]/div/div/div[2]/div/h2");
    private By SearchedProductList = By.xpath("/html/body/section[2]/div/div/div[2]/div");
    private By firstProductHovered = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]");
    private By firstProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
    private By secondProductHovered = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div");
    private By secondProductAddToCart = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
    private By continueBTN = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    private By viewCartBTN = By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");

    private By sleevesDressAdd = By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]/a");


    public AllProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void Verify_user_navigated_ALL_PRODUCTS_page_successfully(){
        driver.assertThat().element(allProductsHeader).isVisible().withCustomReportMessage("Verify user is navigated to ALL PRODUCTS page successfully").perform();
    }

    public void verifyProductsListVisible() {
        driver.assertThat().element(allProductsList).isVisible().withCustomReportMessage("Verify that the products list is visible").perform();
    }

    public ProductDetailPage clickViewProductOfFirstProduct() {
        driver.element().click(ViewProductBTN);
        return new ProductDetailPage(driver);
    }

    public void SearchProduct(String productName){
        driver.element().type(SearchBar, productName);
        driver.element().click(SearchIcon);
    }

    public void VerifySearchedProductVisible(){
        driver.assertThat().element(SearchedProductVisible).isVisible().withCustomReportMessage("Verify 'SEARCHED PRODUCTS' is visible").perform();
    }

    public void verifyAllSearchedProductsVisible() {
        driver.assertThat().element(SearchedProductList).isVisible().withCustomReportMessage("Verify all the products related to search are visible").perform();
    }

    public void hoverOverProducts(){
        driver.element().hover(firstProductHovered);
        driver.element().click(firstProductAddToCart);
        driver.element().click(continueBTN);

        driver.element().hover(secondProductHovered);
        driver.element().click(secondProductAddToCart);
    }

    public CartPage clickViewCartBTN() {
        driver.element().click(viewCartBTN);
        return new CartPage(driver);
    }

    public void addSearchedProduct(){
        driver.element().click(sleevesDressAdd);
        driver.element().click(continueBTN);
    }


}
