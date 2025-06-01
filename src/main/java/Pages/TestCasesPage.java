package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TestCasesPage {

    private SHAFT.GUI.WebDriver driver;
    private By testCasesHeader = By.xpath("//*[@id=\"form\"]/div/div[1]/div/h2/b");

    public TestCasesPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void Verify_user_navigated_to_testCases_page_successfully(){
        driver.assertThat().element(testCasesHeader).isVisible().withCustomReportMessage("Verify user is navigated to test cases page successfully").perform();
    }
}
