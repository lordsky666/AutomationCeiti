package testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.nio.file.Files;
import java.nio.file.Path;

public class Driver {
    public static WebDriver getLocalDriver() {
        try {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            // Creează director temporar valid în /tmp
            Path tempUserDataDir = Files.createTempDirectory(Path.of("/tmp"), "chrome-user-data-");
            options.addArguments("--user-data-dir=" + tempUserDataDir.toAbsolutePath().toString());
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless=new");

            return new ChromeDriver(options);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ChromeDriver", e);
        }
    }
}