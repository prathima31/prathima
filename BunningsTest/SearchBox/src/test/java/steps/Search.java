package steps;

import Base.BaseUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.HomePage;
import pages.SearchResultsPage;

public class Search extends BaseUtil{

    private  BaseUtil base;

    public Search(BaseUtil base) {
        this.base = base;
    }

    @Then("^I should see the search box$")
    public void iShouldSeeTheSearchBox() throws Throwable {
        HomePage homePage=new HomePage(base.Driver);
        Assert.assertTrue("Its not displayed",homePage.isSearchBoxPresent());
    }
    @Then("^I validate the text inside the search box$")
    public void ValidateTheText() throws Throwable {
        HomePage homePage=new HomePage(base.Driver);
        Assert.assertTrue("Text message not displayed",homePage.getSearchBoxPlaceHolderValue().equals("What can we help you find today?"));
    }

    @Then("^I enter the \"([^\"]*)\" in the search box$")
    public void EnterSearchText(String text) throws Throwable {
        HomePage homePage=new HomePage(base.Driver);
        homePage.enterTextInSearchBox(text);

    }

    @Then("^I verify the \"([^\"]*)\" in the search results$")
    public void VerifySearchResults(String text) throws Throwable {
        SearchResultsPage searchResultsPage=new SearchResultsPage(base.Driver);
        Assert.assertTrue("Its not displayed",searchResultsPage.VerifySearchResults(text));

    }

    @Then("^I click on the search product$")
    public void ClickSearchProduct() throws Throwable {
        SearchResultsPage searchResultsPage=new SearchResultsPage(base.Driver);
        searchResultsPage.ClickOnFirstProduct();

    }

    @Then("^I verify the product details as per \"([^\"]*)\"$")
    public void VerifyProduct(String product){
        SearchResultsPage searchResultsPage=new SearchResultsPage(base.Driver);
        Assert.assertTrue("Its not displayed",searchResultsPage.VerifyProduct(product));


    }



}
