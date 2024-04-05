package testng.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertTrue;

public abstract class BasePage {
    static final Duration WAITING_TIME = Duration.ofSeconds(20);

    public void jsClick(SelenideElement selenideElement) {
        selenideElement.should(visible, WAITING_TIME);
        executeJavaScript("arguments[0].click();", selenideElement);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        sleep(2000);
        return screenshot(OutputType.BYTES);
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