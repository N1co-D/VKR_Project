package selenium.testng.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropertiesProcessing {
    private final Properties properties = new Properties();

    public String getSiteFromProperty() {
        File file = new File("src/main/resources/config.properties");
        String site;
        try {
            properties.load(new FileInputStream(file));
            site = properties.getProperty("https://www.pgups.ru/");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла!");
            throw new RuntimeException(e);
        }
        return site;
    }

    public String getBrowserFromProperty() {
        File file = new File("src/main/resources/config.properties");
        String browser;
        try {
            properties.load(new FileInputStream(file));
            browser = properties.getProperty("browser-name");
        } catch (IOException e) {
            System.err.println("Ошибка при загрузке файла!");
            throw new RuntimeException(e);
        }
        return browser;
    }
}