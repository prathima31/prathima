package pages;

import Base.BaseUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SearchResultsPage extends BaseUtil {

    private WebDriver driver;
    public SearchResultsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.XPATH, using = "//article[contains(@class,'SearchProductTilestyle')]/a[1]")
    public WebElement firstSearchProduct;

    public boolean VerifySearchResults(String searchValue){
        boolean elementExists= false;
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement searchResult=driver.findElement(By.xpath("//span[text()='"+searchValue+"']"));
        wait.until(ExpectedConditions.visibilityOf(searchResult));
        elementExists=searchResult.isDisplayed();
        return elementExists;
    }

    public void ClickOnFirstProduct() throws Exception{
        firstSearchProduct.click();
        Thread.sleep(5000);
    }

    public boolean VerifyProduct(String product){
        boolean elementExists= false;
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement searchProduct=driver.findElement(By.xpath("//h1[contains(text(),'"+product+"')]"));
        wait.until(ExpectedConditions.visibilityOf(searchProduct));
        elementExists=searchProduct.isDisplayed();
        return elementExists;
    }

}
