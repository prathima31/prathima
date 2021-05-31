package steps;

import Base.BaseUtil;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;

public class LaunchApp extends BaseUtil{

    private  BaseUtil base;

    public LaunchApp(BaseUtil base) {
        this.base = base;
    }

    @Given("^I launch the application$")
    public void iLaunchTheApplication() throws Throwable {
        System.out.println("Navigate Login Page");
        base.Driver.navigate().to("https://www.bunnings.com.au/");
    }

    @Then("^I should see the home page$")
    public void iShouldSeeTheHomePage() throws Throwable {
        HomePage homePage=new HomePage(base.Driver);
        Assert.assertTrue("Its not displayed",homePage.isLogoPresent());
    }


}
