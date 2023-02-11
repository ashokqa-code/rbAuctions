package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

/**
 * UIInteractionSteps let us define action classes which regroup related actions.
 * The @Step annotation is used to indicate that this action will appear as a step in the reports.
 */
public class HomePage extends BasePage {
    EnvironmentVariables environmentVariables;

    @FindBy(id = "signInBtn")
    protected WebElementFacade signInBtn;

    @Step("Navigate to the home page")
    public void toTheHomePage() {
        openUrl(environmentVariables.getProperty("webdriver.base.url"));
    }

    @Step("User navigated to home page ?")
    public boolean isUserNavigatedToHomePage() {
        return signInBtn.isVisible();
    }
}
