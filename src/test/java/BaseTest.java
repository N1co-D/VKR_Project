import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilites.ConfProperties;

import java.util.HashMap;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class BaseTest {

    @BeforeEach
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
    }

    @AfterEach
    public void quitTest() {
        closeWebDriver();
    }
}