package tests;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import helpers.ApplicationConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SimpleWebsitePage;

import java.time.Duration;

import static com.epam.healenium.SelfHealingDriver.create;
import static helpers.ApplicationConfig.getProperty;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelfHealingTests {

    protected static SelfHealingDriver driver;

    @BeforeEach
    void setup() {
        WebDriver delegate = new ChromeDriver();
        driver = create(delegate);
    }

    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void ClickOnButtonTest() {
        driver.get(getProperty("url"));
        SimpleWebsitePage simpleWebsitePage = new SimpleWebsitePage(driver);

        // Correct selector
        simpleWebsitePage.clickOnButton();

        // Changed selector
        simpleWebsitePage.clickOnButton();
    }
}
