package testng;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import testng.utilites.ConfProperties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeMethod
    public void installTestConfigurations() {
        Configuration.browser = new ConfProperties().getProperty("browser-name");
        Configuration.browserSize = null;
        Configuration.pageLoadStrategy = "none";
        DesiredCapabilities cap = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = cap;
        Configuration.downloadsFolder = "src/downloads";
        Configuration.headless = true;
    }

    @AfterMethod
    public void quitTest() {
        closeWebDriver();
    }
}