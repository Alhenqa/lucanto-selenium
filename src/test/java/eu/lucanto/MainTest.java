package eu.lucanto;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import eu.lucanto.util.TestingUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainTest extends AbstractTest {


//    @Test
    public void testLucantoTitle() {
        driver.get("https://staging.app.lucanto.eu/");
        String title = driver.getTitle();
        if (title.contains("Lucanto")) {
            test.pass("Title contains 'Lucanto'");
        } else {
            test.fail("Title did not contain 'Lucanto'");
        }
//        cy.get('#autocomplete').should('have.value','India')
        testingUtil.validateAttributeValue(By.id("autocomplete"), "India");
        testingUtil.validateValue(driver.findElement(By.id("autocomplete")).getAttribute("value"), "India");
        test.fail("Title did not contain 'Lucanto'");
    }

    @Test
    public void testLogin() {
//
//        env: {
//            USERNAME: 'alhenqa@mail.com',
//                    PASSWORD: 'password123',
//        },
//        function do_login() {
//            cy.get('#user_email').clear().type(Cypress.env('USERNAME'));
//            cy.get('#user_password').clear().type(Cypress.env('PASSWORD'));
//            cy.get('#sign_in_submit_button').click()
//        }
        driver.get("https://staging.app.lucanto.eu/");
        testingUtil.findElement(By.id("user_email")).sendKeys("alhenqa@mail.com");
        testingUtil.findElement(By.id("user_password")).sendKeys("password123");
        testingUtil.findElement(By.id("sign_in_submit_button")).click();

//        cy.get('#main-content > .page', {timeout: 20000}).should('be.visible')
        testingUtil.checkElementVisibilityWithTimeout(By.cssSelector("#main-content > .page"),"login succesful","login failed",20 );
//        List<WebElement> list = driver.findElements(By.cssSelector("#main-content > .page"));
//        if (list.size() > 0) {
//            test.pass("login succesful");
//        } else {
//            test.fail("login failed");
//        }
    }
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        extent.flush(); // Generates the report
    }

    @Override
    String getTestName() {
        return "Lucanto Login Test";
    }
}
