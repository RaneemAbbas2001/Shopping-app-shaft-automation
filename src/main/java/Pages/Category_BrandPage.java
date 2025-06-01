package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Category_BrandPage {
    private SHAFT.GUI.WebDriver driver;
    private By category_brand_Header = By.xpath("/html/body/section/div/div[2]/div[2]/div/h2");
    private By menBTN = By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    private By menSubBTN = By.xpath("//*[@id=\"Men\"]/div/ul/li[1]/a");

    public Category_BrandPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyCategoryPageVisible(String expectedText) {
        driver.assertThat().element(category_brand_Header).isVisible().withCustomReportMessage("Verify category page is displayed").perform();
        driver.assertThat().element(category_brand_Header).text().isEqualTo(expectedText).withCustomReportMessage("Verify category text is '" + expectedText + "'").perform();
    }

    public void clickOnMenBTN() {
        driver.element().click(menBTN);
    }

    public void clickOnSubMentBTN() {
        driver.element().click(menSubBTN);
    }

    public void verifyCategoryPage(String expectedText) {
        driver.assertThat().element(category_brand_Header).isVisible().withCustomReportMessage("Verify category page is displayed").perform();
        driver.assertThat().element(category_brand_Header).text().isEqualTo(expectedText).withCustomReportMessage("Verify category text is '" + expectedText + "'").perform();
    }

    public void verifyBrandPage(String expectedText) {
        driver.assertThat().element(category_brand_Header).isVisible().withCustomReportMessage("Verify brand page is displayed").perform();
        driver.assertThat().element(category_brand_Header).text().isEqualTo(expectedText).withCustomReportMessage("Verify brand text is '" + expectedText + "'").perform();
    }


}
