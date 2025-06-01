package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class LoggedinAccountPage {

    private SHAFT.GUI.WebDriver driver;
    private By loggedInAsText = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a");
    private By deleteAccBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By LogOutBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    private By cartBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");




    public LoggedinAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    public void verifyLoggedInAsVisible(String username) {
        driver.assertThat().element(loggedInAsText).text().contains(username).withCustomReportMessage("Verify that 'Logged in as username' is visible").perform();
    }

    public DeletedAccPage clickDeleteAccountButton() {
        driver.element().click(deleteAccBTN);
        return new DeletedAccPage(driver);
    }

    public Signup_loginPage Logout(){
        driver.element().click(LogOutBTN);
        return new Signup_loginPage(driver);
    }

    public CartPage clickOnCartBTN(){
        driver.element().click(cartBTN);
        return new CartPage(driver);
    }
}
