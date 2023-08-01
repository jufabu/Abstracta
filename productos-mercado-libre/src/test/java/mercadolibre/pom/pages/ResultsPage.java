package mercadolibre.pom.pages;

import mercadolibre.pom.base.BasePage;
import mercadolibre.pom.models.Result;
import mercadolibre.utils.FileUtils;
import mercadolibre.utils.WaitUtils;
import mercadolibre.utils.WebDriverUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static mercadolibre.utils.Constants.MEDIUM_WAIT;

public class ResultsPage extends BasePage {
    private By resultLocator = By.cssSelector(".ui-search-result__wrapper");
    private By productNameLocator = By.cssSelector(".ui-search-item__title");
    private By productCurrencyLocator = By.cssSelector(".andes-money-amount__currency-symbol");
    private By productPriceLocator = By.cssSelector(".andes-money-amount__fraction");
    private By productLinkLocator = By.cssSelector(".ui-search-link");
    private By nextButtonLocator = By.cssSelector(".andes-pagination__button--next");
    private By currentPageLocator = By.cssSelector(".andes-pagination__button--current");

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
    }

    public List<Result> getResultsByPage(final int pages) {
        List<Result> results = new ArrayList<>();
        List<WebElement> resultsElements;
        for (int i = 0; i < pages; i++) {
            resultsElements = webDriver.findElements(resultLocator);
            for (WebElement resultElement : resultsElements) {
                String name = resultElement.findElement(productNameLocator).getText();
                String currency = resultElement.findElement(productCurrencyLocator).getText();
                String price = resultElement.findElement(productPriceLocator).getText();
                String link = resultElement.findElement(productLinkLocator).getAttribute("href");
                results.add(new Result(name, currency, price, link));
            }
            var nextButton = webDriver.findElement(nextButtonLocator);
            WebDriverUtils.scrollIntoView(webDriver, nextButton);
            nextButton.click();
            WaitUtils.WaitUntilElementHasText(webDriver, currentPageLocator, String.valueOf(i + 2), MEDIUM_WAIT);
        }
        return results;
    }

    public void saveResultsToFile(final List<Result> results) {
        Path filePath = Paths.get(FileUtils.class.getClassLoader().getResource("products.txt").getPath());
        FileUtils.clearFile(filePath);
        try (BufferedWriter writer = Files.newBufferedWriter(filePath, StandardCharsets.UTF_8)) {
            for (Result result : results) {
                writer.write(result.toString());
                writer.write("---------------------------------------------------------------------");
                writer.newLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
