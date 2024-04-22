package selenium.testng;

import org.openqa.selenium.WebDriver;

import static selenium.testng.utilites.DriverSingleton.MANAGER;

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