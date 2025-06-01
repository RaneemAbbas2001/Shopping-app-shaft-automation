package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CreatedAccountPage {

    private SHAFT.GUI.WebDriver driver;
    private By accountCreatedHeader = By.xpath("//*[@id=\"form\"]/div/div/div/h2/b");
    private By continueBTN = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");

    public CreatedAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void verifyAccountCreatedVisible() {
        driver.assertThat().element(accountCreatedHeader).text().isEqualTo("ACCOUNT CREATED!").withCustomReportMessage("Verify that 'ACCOUNT CREATED!' is visible").perform();
    }

    public LoggedinAccountPage clickContinueButton() {
        driver.element().click(continueBTN);
        return new LoggedinAccountPage(driver);
    }
}
