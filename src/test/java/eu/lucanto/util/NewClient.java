package eu.lucanto.util;

import eu.lucanto.AbstractTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewClient extends AbstractTest {
    @Override
    public String getTestName() {
        return "NewClient";
    }

    @Test
    public void testNewClient() {

        testingUtil.findElement(By.id("client_index_link")).click();
        testingUtil.findElement(By.id("new-client")).click();
        testingUtil.findElement(By.id("address_name")).sendKeys("TestKlient1");
        testingUtil.findElement(By.className("form-control")).sendKeys("Hrachova");
        testingUtil.findElement(By.id("client_modal_submit")).click();
    }
}