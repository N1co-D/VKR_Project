package selenium.testng.pages;

import io.qameta.allure.Attachment;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static selenium.testng.utilites.DriverSingleton.MANAGER;

public abstract class BasePage {
    static final Duration WAITING_TIME = Duration.ofSeconds(20);
    protected final WebDriverWait webDriverWait = new WebDriverWait(MANAGER.getDriver(), WAITING_TIME);
    private final JavascriptExecutor jsExecutor = (JavascriptExecutor) MANAGER.getDriver();

    public void jsClick(WebElement webElement) {
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        jsExecutor.executeScript("arguments[0].click();", webElement);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ((TakesScreenshot) MANAGER.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    public void checkIfFileExist(String fileName) {
        String downloadDirectory = "src/downloads/";
        File directory = new File(downloadDirectory);
        File[] files = directory.listFiles();
        boolean fileExists = false;

        for (File file : files) {
            if (file.isDirectory()) {
                File[] subFiles = file.listFiles();
                for (File subFile : subFiles) {
                    if (subFile.getName().equals(fileName)) {
                        fileExists = true;
                        break;
                    }
                }
            }
        }

        assertTrue(fileExists, "Файл не был скачан или не найден в директории.");
    }
}

//    static final Duration WAITING_TIME = Duration.ofSeconds(20);
//
//    public void jsClick(SelenideElement selenideElement) {
//        selenideElement.should(visible, WAITING_TIME);
//        executeJavaScript("arguments[0].click();", selenideElement);
//    }
//
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public byte[] makeScreenshot() {
//        sleep(2000);
//        return screenshot(OutputType.BYTES);
//    }
//
//    public void checkIfFileExist(String fileName) {
//        String downloadDirectory = "src/downloads/";
//        File directory = new File(downloadDirectory);
//        File[] files = directory.listFiles();
//        boolean fileExists = false;
//
//        for (File file : files) {
//            if (file.isDirectory()) {
//                File[] subFiles = file.listFiles();
//                for (File subFile : subFiles) {
//                    if (subFile.getName().equals(fileName)) {
//                        fileExists = true;
//                        break;
//                    }
//                }
//            }
//        }
//
//        assertTrue(fileExists, "Файл не был скачан или не найден в директории.");
//    }