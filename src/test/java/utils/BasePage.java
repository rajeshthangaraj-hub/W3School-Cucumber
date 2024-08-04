package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

    public WebDriver driver;
    private Properties prop;

    public BasePage() {
        prop = new Properties();
    }

    // Method to load the properties file
    public void loadData() throws IOException {
        FileInputStream fis = new FileInputStream("C:\\Users\\rthangar\\OneDrive - Capgemini\\Documents\\W3School\\w3school\\src\\test\\resources\\Configuration.properties");
        prop.load(fis);
    }

    // Method to get data from the properties file
    public String getData(String data) {
        return prop.getProperty(data);
    }

    // WebDriverManager method to initialize the WebDriver
    public WebDriver WebDriverManager() throws IOException {
          loadData();

         if (driver == null) {
            if ("CHROME".equalsIgnoreCase(getData("browserName"))) {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars");
                driver = new ChromeDriver(options);
            } else if ("EDGE".equalsIgnoreCase(getData("browserName"))) {
                WebDriverManager.edgedriver().setup();
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--start-maximized");
                options.addArguments("--disable-infobars");
                driver = new EdgeDriver(options);
            }
            driver.get(getData("url"));
        }
        return driver;
    }
}
