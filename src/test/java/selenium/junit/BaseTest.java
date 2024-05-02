package selenium.junit;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import selenide.junit.utilites.ConfProperties;

import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static selenium.junit.utilites.DriverSingleton.MANAGER;

public class BaseTest {
    protected WebDriver driver = MANAGER.getDriver();
}
//
//    @BeforeEach
//    public void installTestConfigurations() {
//        driver.manage().window().maximize();
//        driver.manage().deleteAllCookies();
////        driver.get("https://pgups.ru/");
//    }
//
//    @AfterEach
//    public void quitTest() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}

//    @BeforeEach
//    public void installTestConfigurations() {
//        Configuration.browser = new ConfProperties().getProperty("browser-name");
//        Configuration.browserSize = null;
//        Configuration.pageLoadStrategy = "none";
//        DesiredCapabilities cap = new DesiredCapabilities();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        cap.setCapability(ChromeOptions.CAPABILITY, options);
//        Configuration.browserCapabilities = cap;
//        Configuration.downloadsFolder = "src/downloads";
//        Configuration.headless = true;
//    }
//
//    @AfterEach
//    public void quitTest() {
//        closeWebDriver();
//    }
//}