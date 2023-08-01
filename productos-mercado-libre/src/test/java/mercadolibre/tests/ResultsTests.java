package mercadolibre.tests;

import mercadolibre.pom.models.Result;
import mercadolibre.pom.pages.HomePage;
import mercadolibre.pom.pages.ResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ResultsTests extends BaseTest {
    private HomePage homePage;
    private ResultsPage resultsPage;
    @Test
    void saveResultsToFileTest() {
        homePage = new HomePage(webDriver);
        homePage.goToHomePage();
        Assert.assertTrue(homePage.isHomePageOpened(), "The home page should be opened, but it is not");
        resultsPage = homePage.search("camisetas");
        List<Result> results = resultsPage.getResultsByPage(3);
        resultsPage.saveResultsToFile(results);
    }
}
