package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    private static WebDriver driver;
    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getenv("BROWSER");
            browser = (browser == null) ? "CHROME" : browser;
            switch (browser) {
                case "IE":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "CHROME":
                default:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    if ("Y".equalsIgnoreCase(System.getenv("HEADLESS"))) {
                        options.addArguments("--headless");
                        options.addArguments("--disable-gpu");
                    }
                    driver = new ChromeDriver(options);
                    break;
            }
        }
        return driver;
    }
}

