package mercadolibre.tests;

import mercadolibre.utils.GetProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

import static mercadolibre.utils.Constants.MEDIUM_WAIT;

public class BaseTest {
    protected WebDriver webDriver;
    protected static GetProperties properties = new GetProperties();
    private static String browser = properties.getString("browser").toUpperCase();

    @BeforeSuite
    void setup() {
        switch (browser) {
            case "CHROME":
                webDriver = new ChromeDriver();
                break;
            case "FIREFOX":
                webDriver = new FirefoxDriver();
                break;
            case "EDGE":
                webDriver = new EdgeDriver();
                break;
            case "SAFARI":
                webDriver = new SafariDriver();
                break;
            default:
                webDriver = new ChromeDriver();
        }
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(MEDIUM_WAIT));
    }

    @AfterSuite
    void tearDown() {
        webDriver.quit();
    }
}
