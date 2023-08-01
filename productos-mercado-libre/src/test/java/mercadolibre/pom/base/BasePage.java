package mercadolibre.pom.base;

import mercadolibre.utils.GetProperties;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected static GetProperties properties = new GetProperties();
    protected static String url = properties.getString("url");
    protected WebDriver webDriver;

    public BasePage(final WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
