package pages;

import net.serenitybdd.core.steps.UIInteractions;
import net.serenitybdd.screenplay.actions.Scroll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends UIInteractions {

    public void waitUntilVisible(WebElement element, int wait, int polling) {
        WebDriverWait webDriverWait = new WebDriverWait(this.getDriver(), Duration.ofSeconds(wait), Duration.ofSeconds(polling));
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element){
        Scroll.to(element);
    }
}
