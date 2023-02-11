package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import pages.HomePage;
import pages.SearchActions;

public class HomePageSteps {

    @Steps
    HomePage homePage;

    @Steps
    SearchActions searchActions;

    @Given("User navigated to home page")
    public void user_navigated_to_home_page() {
        homePage.toTheHomePage();
        Assert.assertTrue("User not navigated to home page", homePage.isUserNavigatedToHomePage());
    }

    @Then("Search for {string} using search bar")
    public void search_for_using_search_bar(String searchItem) {
        searchActions.searchBy(searchItem);
    }

    @Then("Validate the results count showed on the home page")
    public void validate_the_results_count_showed_on_the_home_page() {
        int defaultSearchCount = searchActions.getSearchResultsCount();
        Assert.assertTrue(" search result haven't showed up", defaultSearchCount > 0);
        Serenity.setSessionVariable("defaultSearchCount").to(defaultSearchCount);
    }

    @Then("Validate first result on the page has the word {string} in it")
    public void validate_first_result_on_the_page_has_the_word_in_it(String title) {
        Assert.assertTrue("First Result title doesn't contain - " + title, searchActions.isSearchResultsTitleDisplayed(title));
    }

    @Then("User applies the year filter to be from {string} to current year")
    public void user_applies_the_year_filter_to_be_from_to_current_year(String fromYear) {
        searchActions.inputYearInFilter(fromYear);
    }

    @Then("Validate results count returned is different after filter applied")
    public void validate_results_count_returned_is_different_after_filter_applied() {
        int defaultCount = Integer.parseInt(Serenity.getCurrentSession().get("defaultSearchCount").toString());
        Assert.assertTrue("search result are not different after filter is applied", defaultCount >= searchActions.getSearchResultsCount());
    }
}
