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

            // Creează director temporar în /tmp pentru Linux/GitHub Actions
            Path tempUserDataDir = Files.createTempDirectory("/tmp/chrome-user-data");
            options.addArguments("--user-data-dir=" + tempUserDataDir.toAbsolutePath().toString());
            options.addArguments("--no-sandbox"); // necesar pe GitHub Actions / Docker
            options.addArguments("--disable-dev-shm-usage"); // evită probleme cu /dev/shm
            options.addArguments("--headless=new"); // rulează headless pentru CI

            return new ChromeDriver(options);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create ChromeDriver", e);
        }
    }
}