package eu.lucanto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import eu.lucanto.util.TestingUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTest {

    protected static WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;
    protected TestingUtil testingUtil;

    public abstract String getTestName();

    private static ExtentSparkReporter sparkReporter;

    @BeforeAll

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        if (sparkReporter == null) {
            sparkReporter = new ExtentSparkReporter("test-report.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }

    }

    @BeforeEach
    public void before(TestInfo testInfo) {
        test = extent.createTest(testInfo.getDisplayName()).assignCategory(getTestName());

        testingUtil = new TestingUtil(driver, test);
        driver.get("https://staging.app.lucanto.eu");
        driver.findElement(By.id("user_email")).sendKeys("alhenqa@mail.com");
        driver.findElement(By.id("user_password")).sendKeys("password123");
        driver.findElement(By.id("sign_in_submit_button")).click();
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush(); // Generates the report
    }

}
