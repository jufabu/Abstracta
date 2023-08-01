package mercadolibre.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    public static void WaitUntilElementHasText(final WebDriver webDriver, final By elementLocator, final String expectedText,
                                               final int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.textToBe(elementLocator, expectedText));
        }
        catch (Exception e) {
            throw e;
        }
    }

    public static void WaitUntilElementIsDisplayed(final WebDriver webDriver, final By elementLocator, final int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
            wait.until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        }
        catch (Exception e) {
            throw e;
        }
    }
}
