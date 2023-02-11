package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.time.Year;
import java.util.List;

public class SearchActions extends HomePage {

    @FindBy(id = "simple-keyword-search")
    protected WebElementFacade searchBar;

    @FindBy(id = "lblShowResultsFor")
    protected WebElementFacade searchResultsCount;

    @FindBy(xpath = "//h3[contains(@id,'_ci_title')]")
    protected List<WebElement> resultsTitle;

    @FindBy(xpath = " //div[@id='manufacturer_year_dt']//input[@type='number'][1]")
    protected WebElementFacade searchStartYear;

    @FindBy(xpath = " //div[@id='manufacturer_year_dt']//input[@type='number'][2]")
    protected WebElementFacade searchEndYear;

    @Step("Search by keyword")
    public void searchBy(String keyword) {
        searchBar.sendKeys(keyword, Keys.ENTER);
    }

    @Step("Get search results count displayed")
    public int getSearchResultsCount() {
        return Integer.parseInt(searchResultsCount.getText().split("\\s+")[1]);
    }

    @Step("Get search results displayed")
    public boolean isSearchResultsTitleDisplayed(String title) {
        return resultsTitle.stream().findFirst().filter(element -> element.getText().contains(title)).isPresent();
    }

    @Step("Inputs from start and to year in the filter")
    public void inputYearInFilter(String fromYear) {
        this.searchStartYear.clear();
        try {
            this.searchStartYear.sendKeys(fromYear);
        } catch (StaleElementReferenceException exception) {
            this.searchStartYear.sendKeys(fromYear);
        }
        this.searchEndYear.clear();
        try {
            this.searchEndYear.sendKeys(Integer.toString(Year.now().getValue()));
        } catch (StaleElementReferenceException exception) {
            this.searchEndYear.sendKeys(Integer.toString(Year.now().getValue()));
        }
    }
}
