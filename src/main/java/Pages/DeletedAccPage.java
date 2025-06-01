package Pages;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class DeletedAccPage {

    private SHAFT.GUI.WebDriver driver;
    private By accDeletedHeader = By.xpath("//h2[@data-qa='account-deleted']");
    private By continueBTN = By.xpath("//a[@data-qa='continue-button']");


    public DeletedAccPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAccountDeletedVisible() {
        driver.assertThat().element(accDeletedHeader).text().isEqualTo("ACCOUNT DELETED!").withCustomReportMessage("Verify that 'ACCOUNT DELETED!' is visible").perform();
    }

    public HomePage clickContinueButton() {
        driver.element().click(continueBTN);
        return new HomePage(driver);
    }

}
