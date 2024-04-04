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

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "src/downloads");

        DesiredCapabilities cap = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", chromePrefs);

        options.addArguments("start-maximized");
        cap.setCapability(ChromeOptions.CAPABILITY, options);
        Configuration.browserCapabilities = cap;
//        Configuration.headless = true;
    }

    @AfterEach
    public void quitTest() {
        closeWebDriver();
    }
}