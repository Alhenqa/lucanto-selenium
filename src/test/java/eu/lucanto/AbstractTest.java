package eu.lucanto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import eu.lucanto.util.TestingUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class AbstractTest {

    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;
    protected TestingUtil testingUtil;

    abstract String getTestName();

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        ExtentSparkReporter spark = new ExtentSparkReporter("test-report.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest(getTestName());
        testingUtil = new TestingUtil(driver, test);
    }
}
