package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class Account_info_Page {

    private SHAFT.GUI.WebDriver driver;
    private By AccountInfoHeader= By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/h2/b");
    private By genderMrsRadioBTN = By.id("id_gender2");
    private By passwordField = By.id("password");
    private By dayDropdown = By.id("days");
    private By monthDropdown = By.id("months");
    private By yearDropdown = By.id("years");
    private By newsletterCheckbox = By.id("newsletter");
    private By offersCheckbox = By.id("optin");
    private By firstNameField = By.id("first_name");
    private By lastNameField = By.id("last_name");
    private By companyField = By.id("company");
    private By addressField = By.id("address1");
    private By address2Field = By.id("address2");
    private By countryDropdown = By.id("country");
    private By stateField = By.id("state");
    private By cityField = By.id("city");
    private By zipcodeField = By.id("zipcode");
    private By mobileNumberField = By.id("mobile_number");
    private By createAccountBTN = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");



    public Account_info_Page(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    public void verifyEnterAccountInfoVisible() {
        driver.assertThat().element(AccountInfoHeader).text().isEqualTo("ENTER ACCOUNT INFORMATION").withCustomReportMessage("Verify that 'ENTER ACCOUNT INFORMATION' is visible").perform();
    }

    public void fillAccountDetails(String password, String day, String month, String year) {
        driver.element().click(genderMrsRadioBTN);
        driver.element().type(passwordField, password);
        driver.element().select(dayDropdown, day);
        driver.element().select(monthDropdown, month);
        driver.element().select(yearDropdown, year);

    }

    public void selectNewsLetterAndOffers(){
        driver.element().click(newsletterCheckbox);
        driver.element().click(offersCheckbox);
    }

    public void fillAddressDetails(String firstName , String lastName , String company , String address , String address2 , String country , String state , String city , String zipcode , String mobileNumber){
        driver.element().type(firstNameField, firstName);
        driver.element().type(lastNameField, lastName);
        driver.element().type(companyField, company);
        driver.element().type(addressField, address);
        driver.element().type(address2Field, address2);
        driver.element().select(countryDropdown, country);
        driver.element().type(stateField, state);
        driver.element().type(cityField, city);
        driver.element().type(zipcodeField, zipcode);
        driver.element().type(mobileNumberField, mobileNumber);
    }

    public CreatedAccountPage clickCreateAccountButton() {
        driver.element().click(createAccountBTN);
        return new CreatedAccountPage(driver);
    }
}
