package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Driver {

    // Driver local
    public static WebDriver getLocalDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--user-data-dir=/tmp/local-profile-" + System.currentTimeMillis());
        return new ChromeDriver(options);
    }

    // Driver remote (Selenoid / Selenium Grid)
    public static RemoteWebDriver getRemoteDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");
        options.addArguments("--user-data-dir=/tmp/remote-profile-" + System.currentTimeMillis());

        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVNC", true);
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableLog", true);
        selenoidOptions.put("name", "Test badge");
        selenoidOptions.put("sessionTimeout", "15m");

        options.setCapability("selenoid:options", selenoidOptions);

        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return driver;
    }
}