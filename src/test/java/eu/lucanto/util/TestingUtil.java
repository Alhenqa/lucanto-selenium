package eu.lucanto.util;

import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestingUtil {

    private final WebDriver driver;
    private final ExtentTest test;

    public TestingUtil(WebDriver webdriver, ExtentTest test) {
        this.driver = webdriver;
        this.test = test;
    }

    public void validateAttributeValue(By element, String expectedValue) {
        validateAttributeValue(element, expectedValue, "");
    }

    public void validateAttributeValue(By element, String expectedValue, String message) {
        String currentValue = driver.findElement(element).getAttribute("value");
        validateValue(currentValue, expectedValue, message);
    }

    public void validateValue(String currentValue, String expectedValue) {
        validateValue(currentValue, expectedValue, "");
    }

    public void validateValue(String currentValue, String expectedValue, String message) {
        if (expectedValue.equals(currentValue)) {
            test.pass(message + " - Value is correct: '" + expectedValue + "'");
        } else {
            test.fail(message + " - Expected: '" + expectedValue + "', but found: '" + currentValue + "'");
        }
    }

    public WebElement findElement(By element) {
        return findElement(element, 4);
    }

    public WebElement findElement(By locator, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            return null;
        }
    }

    public void checkElementVisibilityWithTimeout(By locator, String successMessage, String failureMessage) {
        checkElementVisibilityWithTimeout(locator, successMessage, failureMessage, 4);
    }

    public void checkElementVisibilityWithTimeout(By locator, String successMessage, String failureMessage, int timeoutSeconds) {
        try {
            WebElement element = findElement(locator, timeoutSeconds);
            if (element.isDisplayed()) {
                test.pass(successMessage);
            }
        } catch (Exception e) {
            test.fail(failureMessage + " - " + e.getMessage());
        }
    }
}
