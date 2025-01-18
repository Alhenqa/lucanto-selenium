package eu.lucanto;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.systeminfo.SystemInfo;

public class Main {

    public static void main(String[] params) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Open Google Slovakia
            driver.get("https://staging.app.lucanto.eu/");

            assert(driver.getTitle().equals("Lucantos"));
            assert(driver.getTitle().equals("Lucanto"));
        } finally {
            driver.quit();
        }
    }
}
