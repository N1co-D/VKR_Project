package selenium.testng.utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public enum DriverSingleton {
    MANAGER;
    private WebDriver driver;

    DriverSingleton() {
    }

    public WebDriver getDriver() {
        if (driver == null) {
            ConfigPropertiesProcessing configPropertiesProcessing = new ConfigPropertiesProcessing();
            System.out.println("Определен браузер: " + configPropertiesProcessing.getBrowserFromProperty());
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);
//            driver = WebDriverManager.getInstance(configPropertiesProcessing.getBrowserFromProperty()).create();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        }
        return driver;
    }
}
