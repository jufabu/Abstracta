package mercadolibre.pom.pages;

import mercadolibre.pom.base.BasePage;
import mercadolibre.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import static mercadolibre.utils.Constants.LONG_WAIT;

public class HomePage extends BasePage {

    private By inputSearchLocator = By.name("as_word");
    private By logoSelector = By.cssSelector("a.nav-logo");
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public ResultsPage search(final String word) {
        var searchInput = webDriver.findElement(inputSearchLocator);
        searchInput.sendKeys(word);
        searchInput.sendKeys(Keys.ENTER);
        return new ResultsPage(webDriver);
    }

    public void goToHomePage() {
        webDriver.get(url);
    }

    public boolean isHomePageOpened() {
        WaitUtils.WaitUntilElementIsDisplayed(webDriver, logoSelector, LONG_WAIT);
        return webDriver.findElement(logoSelector).isDisplayed();
    }
}
