package pages;

import Base.BaseUtil;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BaseUtil {

    private WebDriver driver;
    public HomePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(how = How.XPATH, using = "//a[@data-locator='logo-Bunnings']")
    public WebElement bunningsLogo;

    @FindBy(how = How.XPATH, using = "//input[@type='search']")
    public WebElement searchBox;



    public boolean isLogoPresent() {
        boolean present=false;
        present=bunningsLogo.isDisplayed();
        return present;
    }
    public boolean isSearchBoxPresent() {
        boolean present = false;
        present = searchBox.isDisplayed();
        return present;
    }

    public String getSearchBoxPlaceHolderValue() {

        String searchBoxValue = searchBox.getAttribute("placeholder");
        return searchBoxValue;
    }

    public void enterTextInSearchBox(String searchValue) throws Exception {
        searchBox.sendKeys(searchValue);
        Thread.sleep(5000);
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.ENTER).build().perform();
        Thread.sleep(5000);

    }
}
