package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class HomePage {

    private SHAFT.GUI.WebDriver driver;
    private String HomePageURL="https://automationexercise.com/";
    private By signup_LoginButton= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By homePageSlider = By.id("slider");
    private By contactUsBTN= By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    private By testCasesBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By ProductsBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
    private By subscriptionFooter = By.xpath("//*[@id=\"footer\"]/div[1]/div/div/div[2]/div/h2");
    private By descriptionEmail = By.id("susbscribe_email");
    private By descriptionEmailArrow = By.id("subscribe");
    private By successSubscriptionAlert = By.xpath("//*[@id=\"success-subscribe\"]/div");
    private By cartBTN = By.cssSelector("#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a");
    private By featureHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/h2");
    private By viewProductBTN = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[2]/ul/li/a");

    private By product1 = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[2]/div/div[1]/div[1]/a");
    private By product2 = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[1]/a");
    private By product3 = By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[4]/div/div[1]/div[1]/a");
    private By continueBTN = By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
    private By catgoryLeftSideBar = By.xpath("/html/body/section[2]/div/div/div[1]/div/h2");
    private By brandLeftSideBar = By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[2]/h2");
    private By womenBTN = By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    private By womenSubBTN = By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    private By brandNameBTN = By.xpath("/html/body/section[2]/div/div/div[1]/div[1]/div[2]/div/ul/li[2]/a");
    private By RecommendHeader = By.xpath("/html/body/section[2]/div/div/div[2]/div[2]/h2");
    private By addRecommendProduct = By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a");
    private By moveUpwardBTN = By.id("scrollUp");
    private By FullFledgedText = By.xpath("//*[@id=\"slider-carousel\"]/div/div[1]/div[1]/h2");
    private By Header = By.xpath("//*[@id=\"header\"]/div");


    public HomePage(SHAFT.GUI.WebDriver driver){
        this.driver= driver;
    }

    public void navigateToHomePage() {
        driver.browser().navigateToURL(HomePageURL);
    }

    public void verifyHomePageVisible() {
        driver.assertThat().element(homePageSlider).isVisible().withCustomReportMessage("Verify that home page is visible successfully").perform();
    }

    public Signup_loginPage clickSignupLoginButton() {
        driver.element().click(signup_LoginButton);
        return new Signup_loginPage(driver);
    }

    public ContactUsPage clickContactUsBTN() {
        driver.element().click(contactUsBTN);
        return new ContactUsPage(driver);
    }

    public TestCasesPage clickTestCasesBTN() {
        driver.element().click(testCasesBTN);
        return new TestCasesPage(driver);
    }

    public AllProductsPage clickProductsBTN() {
        driver.element().click(ProductsBTN);
        return new AllProductsPage(driver);
    }

    public void scrollDownFooter(){
        driver.element().scrollToElement(subscriptionFooter);
    }

    public void Verify_text_SUBSCRIPTION() {
        driver.assertThat().element(subscriptionFooter).text().isEqualTo("SUBSCRIPTION").withCustomReportMessage("Verify 'SUBSCRIPTION' text in footer").perform();
    }

    public void enter_SUBSCRIPTION(String desciptEmail ){
        driver.element().type(descriptionEmail,desciptEmail);
        driver.element().click(descriptionEmailArrow);
    }

    public void Verify_success_message_YouHaveBeenSuccessfullySubscribed() {
        driver.assertThat().element(successSubscriptionAlert).isVisible().withCustomReportMessage("Verify success message is visible").perform();
    }

    public CartPage clickCartBTN() {
        driver.element().click(cartBTN);
        return new CartPage(driver);
    }

    public void scrollDownToFeature(){
        driver.element().scrollToElement(featureHeader);
    }

    public ProductDetailPage clickViewProductBTN() {
        driver.element().click(viewProductBTN);
        return new ProductDetailPage(driver);
    }

    public void addProducts(){
        driver.element().click(product1);
        driver.element().click(continueBTN);

        driver.element().click(product2);
        driver.element().click(continueBTN);

        driver.element().click(product3);
        driver.element().click(continueBTN);
    }

    public void scrollToCategoryLeftSideBar(){
        driver.element().scrollToElement(catgoryLeftSideBar);
    }

    public void VerifyCategoriesVisibleLeftSidebar() {
        driver.assertThat().element(catgoryLeftSideBar).isVisible().withCustomReportMessage("Verify that categories are visible on left side bar").perform();
    }

    public void VerifyBrandVisibleLeftSidebar() {
        driver.assertThat().element(brandLeftSideBar).isVisible().withCustomReportMessage("Verify that brand is visible on left side bar").perform();
    }

    public void clickOnWomenBTN() {
        driver.element().click(womenBTN);
    }

    public Category_BrandPage clickOnSubWomenBTN() {
        driver.element().click(womenSubBTN);
        return new Category_BrandPage(driver);
    }

    public Category_BrandPage clickBrandBTN() {
        driver.element().click(brandNameBTN);
        return new Category_BrandPage(driver);
    }

    public void scrollDownToRecommendedItems(){
        driver.element().scrollToElement(RecommendHeader);
    }

    public void VerifyRECOMMENDED_ITEMSVisible() {
        driver.assertThat().element(RecommendHeader).isVisible().withCustomReportMessage("Verify 'RECOMMENDED ITEMS' are visible").perform();
    }

    public void addRecommendProduct(){
        driver.element().click(addRecommendProduct);
    }

    public void clickOnMoveUpwardBTN() {
        driver.element().click(moveUpwardBTN);
    }

    public void VerifyFullFledgedAutomationEngineersTextVisibleOnScreen(){
        driver.assertThat().element(FullFledgedText).isVisible().withCustomReportMessage("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen").perform();
    }

    public void scrollUpToHeader(){
        driver.element().scrollToElement(Header);
    }



}
