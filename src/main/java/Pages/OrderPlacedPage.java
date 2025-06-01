package Pages;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

import java.io.File;
import java.nio.file.Paths;

public class OrderPlacedPage {
    private SHAFT.GUI.WebDriver driver;
    private By deleteBTN = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    private By invoiceBTN = By.xpath("//*[@id=\"form\"]/div/div/div/a");
    private By continueBTN = By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    private String downloadDirectory;




    public OrderPlacedPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public DeletedAccPage clickOnDeleteBTN(){
        driver.element().click(deleteBTN);
        return new DeletedAccPage(driver);
    }

    public void clickOnInvoiceBTN(){
        driver.element().click(invoiceBTN);
    }

    public void clickOnContinueBTN(){
        driver.element().click(continueBTN);
    }

    public void verifyInvoiceDownloadedSuccessfully(String expectedInvoiceFileName){
        String expectedFilePath = Paths.get(downloadDirectory, expectedInvoiceFileName).toString();
        File downloadedFile = new File(expectedFilePath);
//        driver.assertThat().file(downloadedFile).exists().withCustomReportMessage("Verify that the invoice file was downloaded.").perform();
    }

}
