package tests;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.SelfHealingDriverWait;
import helpers.ApplicationConfig;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.SimpleWebsitePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Objects;

import static com.epam.healenium.SelfHealingDriver.create;
import static helpers.ApplicationConfig.getProperty;
import static java.lang.System.getenv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SelfHealingTests {

    protected static WebDriver driver;

    @BeforeEach
    void setup() throws MalformedURLException {

        ChromeOptions options = new ChromeOptions();

        driver = Objects.equals(getProperty("env"), "REMOTE")
                ? new RemoteWebDriver(new URL(getProperty("nodeUrl")), options)
                : create(new ChromeDriver());
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
