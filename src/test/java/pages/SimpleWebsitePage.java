package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class SimpleWebsitePage {

    protected WebDriver driver;

    public SimpleWebsitePage(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(className = "click-me-button")
    private WebElement clickOnMeButton;

    public void clickOnButton() {
        clickOnMeButton.click();
    }
}
